package ar.edu.unnoba.Proyecto.controller;

import ar.edu.unnoba.Proyecto.service.ActividadService;
import ar.edu.unnoba.Proyecto.service.AlquilerService;
import ar.edu.unnoba.Proyecto.service.EventoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class ImageController {

    private final EventoService eventoService;

    private final ActividadService actividadService;
    private final AlquilerService alquilerService;

    @Autowired
    public ImageController(EventoService eventoService, ActividadService actividadService, AlquilerService alquilerService) {
        this.eventoService = eventoService;
        this.actividadService = actividadService;
        this.alquilerService = alquilerService;
    }

    // muestra la imagen dado un id
    @Transactional
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") long id) throws SQLException {
        byte[] imageBytes = eventoService.getImageBytes(id);
        if (imageBytes != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @GetMapping("/display/actividad")
    public ResponseEntity<byte[]> displayActividadImage(@RequestParam("id") long id) throws SQLException {
        byte[] imageBytes = actividadService.getImageBytes(id);
        if (imageBytes != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @GetMapping("/display/alquiler")
    public ResponseEntity<byte[]> displayAlquilerImage(@RequestParam("id") long id) throws SQLException {
        byte[] imageBytes = alquilerService.getImageBytes(id);
        if (imageBytes != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
