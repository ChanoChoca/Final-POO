package ar.edu.unnoba.Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    @GetMapping("/login")
    public String login() {
        return "autenticaciones/login";
    }
}
