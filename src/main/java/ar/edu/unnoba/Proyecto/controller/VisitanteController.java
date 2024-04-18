package ar.edu.unnoba.Proyecto.controller;

import ar.edu.unnoba.Proyecto.model.*;
import ar.edu.unnoba.Proyecto.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/visitante")
public class VisitanteController {

    private final EventoService eventoService;
    private final SubscriptorService subscriptorService;
    private final ActividadService actividadService;
    private final AlquilerService alquilerService;
    private final CartDetailsService cartDetailsService;
    private final FamiliaService familiaService;


    @Autowired
    private VisitanteController(EventoService eventoService, SubscriptorService subscriptorService, ActividadService actividadService, AlquilerService alquilerService, CartDetailsService cartDetailsService, FamiliaService familiaService) {
        this.eventoService = eventoService;
        this.subscriptorService = subscriptorService;
        this.actividadService = actividadService;
        this.alquilerService = alquilerService;
        this.cartDetailsService = cartDetailsService;
        this.familiaService = familiaService;
    }

    //*****************INICIO*****************

    @GetMapping("")
    public String redireccion() {
        return "redirect:/visitante/inicio";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "visitantes/inicio";
    }

    //*****************EVENTOS*****************

    /*
    Cada vez que se ingrese a ver los eventos, se aparecerá de forma emergente en la misma pestaña
    un formulario para almacenar un nuevo subcriptor.
    */

    @GetMapping("/eventos")
    public String eventos(Model model,
                          @RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "9") int size,
                          @RequestParam(required = false, defaultValue = "") String title) {

        Page<Evento> eventoPage = eventoService.getPageWithTitleFilter(page - 1, size, title);

        model.addAttribute("eventos", eventoPage);
        model.addAttribute("sub", new Subscriptor());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", eventoPage.getTotalPages());
        model.addAttribute("searchText", title);
        return "visitantes/eventos";
    }//FUNCIONALIDAD: Listado de todas los eventos

    @PostMapping("/eventos")
    public String eventos(@ModelAttribute("sub") Subscriptor subscriptor) {
        subscriptorService.save(subscriptor);
        return "redirect:/visitante/eventos";
    }

    //*****************EVENTO (AL SELECCIONAR CLICKEANDO)*****************

    @GetMapping("/evento/{id}")
    public String evento(@PathVariable Long id, Model model) {

        Evento evento = eventoService.get(id);
        model.addAttribute("evento", evento);


        return "visitantes/evento";
    }//FUNCIONALIDAD: Mostrar en detalle un Evento

    //*****************CONTACTO*****************

    @GetMapping("/contacto")
    public String mostrarFormulario() {
        return "visitantes/contacto";
    }//FUNCIONALIDAD: muestra la vista de contacto con su formulario


    @PostMapping("/contacto")
    public String recibirMensaje() {
        return "redirect:/visitante/inicio";
    }

    @GetMapping("/historia")
    public String historia(){
        return "visitantes/historia";
    }

    @GetMapping("/actividades")
    public String actividades(Model model,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "9") int size,
                              @RequestParam(required = false, defaultValue = "") String title) {

        Page<Actividad> actividadPage = actividadService.getPageWithTitleFilter(page - 1, size, title);

        model.addAttribute("actividades", actividadPage);
        model.addAttribute("currentPage", page); // info de la pag actual para cambiar de pagina
        model.addAttribute("totalPages", actividadPage.getTotalPages()); // cant total de paginas
        model.addAttribute("searchText", title);
        return "visitantes/actividades";
    }

    @GetMapping("/alquileres")
    public String alquileres(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "9") int size,
                             @RequestParam(required = false, defaultValue = "") String title,
                             @RequestParam(required = false) Integer minPrice,
                             @RequestParam(required = false) Integer maxPrice,
                             @RequestParam(required = false, defaultValue = "false") Boolean wifi,
                             @RequestParam(required = false, defaultValue = "false") Boolean bufet) {

        Page<Alquiler> alquilerPage;

        if (!title.isEmpty() || minPrice != null || maxPrice != null || wifi || bufet) {
            alquilerPage = alquilerService.getPageWithFilters(page - 1, size, title, minPrice, maxPrice, wifi, bufet);
        } else {
            alquilerPage = alquilerService.getPageWithoutFilter(page - 1, size);
        }

        model.addAttribute("alquileres", alquilerPage);
        model.addAttribute("currentPage", page); // información de la página actual para cambiar de página
        model.addAttribute("totalPages", alquilerPage.getTotalPages()); // cantidad total de páginas
        model.addAttribute("searchText", title);
        return "visitantes/alquileres";
    }

    @GetMapping("/cart-details/{id}")
    public String cartDetails(@PathVariable Long id,
                              Model model) {
        Alquiler alquiler = alquilerService.get(id);
        model.addAttribute("alquiler", alquiler);

        return "visitantes/cart-details";
    }

    @Value("${stripe.api.publicKey}")
    private String publicKey;

    @PostMapping("/cart-details/{id}")
    public String cartDetails(@PathVariable Long id,
                              @RequestParam("desde") LocalDate desde,
                              @RequestParam("hasta") LocalDate hasta,
                              Model model) {

        Alquiler alquiler = alquilerService.get(id);
        CartDetails cart = new CartDetails(desde, hasta, (int) (alquiler.getPrecio() * (ChronoUnit.DAYS.between(desde, hasta) + 1)));
        cartDetailsService.save(cart);
        alquiler.setCartDetails(cart);
        alquilerService.save(alquiler);

        model.addAttribute("publicKey", publicKey);
        model.addAttribute("amount", cart.getTotal());
        model.addAttribute("email", "");
        model.addAttribute("productName", alquiler.getTitulo());

        model.addAttribute("alquiler", alquiler);

        return "visitantes/checkout";
        //return "redirect:/rent/checkout";
    }

    //----------------FAMILIA---------------------

    @GetMapping("/familia")
    public String familia(Model model,
                          @RequestParam(required = false, defaultValue = "") String title){

        List<String> apellidosList;

        if (title == null || title.isEmpty()){
            apellidosList = familiaService.getApellidoSinRepetir();
        }
        else{
            apellidosList = familiaService.getApellidosFiltrados(title);
        }
        model.addAttribute("searchText", title);
        model.addAttribute("ApellidosList", apellidosList);

        return "visitantes/familias";
    }

    @GetMapping("/familia_ver-mas")
    public String nombresDelApellido(Model model,
                                     @RequestParam("apellido") String apellido,
                                     @RequestParam(required = false, defaultValue = "") String nombrePersona){
        List<Familia> PersonasList;
        if(nombrePersona == null || nombrePersona.isEmpty()){
            PersonasList = familiaService.getFamiliaPorApellido(apellido);
        }
        else{
            PersonasList = familiaService.getFamiliaPorApellido(apellido);

            // Filtrar las familias por nombre, ignorando mayúsculas y minúsculas y permitiendo coincidencias parciales

            PersonasList = PersonasList.stream()
                    .filter(familia -> familia.getNombre().toLowerCase().contains(nombrePersona.toLowerCase()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("personas", PersonasList);

        return "visitantes/familia";
    }

}
