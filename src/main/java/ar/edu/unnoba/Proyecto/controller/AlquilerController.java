package ar.edu.unnoba.Proyecto.controller;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import ar.edu.unnoba.Proyecto.model.Evento;
import ar.edu.unnoba.Proyecto.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {

    private final AlquilerService alquilerService;

    @Autowired
    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/alquileres")
    public String alquileres(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "9") int size,
                             @RequestParam(required = false, defaultValue = "") String title) {

        Page<Alquiler> alquilerPage = alquilerService.getPageWithTitleFilter(page - 1, size, title);

        model.addAttribute("alquileres", alquilerPage);
        model.addAttribute("currentPage", page); // info de la pag actual para cambiar de pagina
        model.addAttribute("totalPages", alquilerPage.getTotalPages()); // cant total de paginas
        model.addAttribute("searchText", title);
        return "alquileres/alquileres";
    }

    @PostMapping("/alquileres")
    public String compra(Model model) {

        return "redirect:/visitantes/inicio";
    }
}
