package ar.edu.unnoba.Proyecto.controller;

import ar.edu.unnoba.Proyecto.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    @Autowired
    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/lista")
    public String alquileres(Model model){
        model.addAttribute("alquileres", alquilerService.getAll());
        return "alquileres/lista";
    }

    @PostMapping("/lista")
    public String compra(Model model) {

        return "redirect:/visitantes/inicio";
    }
}
