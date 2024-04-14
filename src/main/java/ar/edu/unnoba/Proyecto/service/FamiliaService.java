package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Familia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface FamiliaService {

    List<String> getApellidoSinRepetir();
    List<String> getApellidosFiltrados(String apellido);
    List<Familia> getFamiliaPorApellido(String apellido);
}
