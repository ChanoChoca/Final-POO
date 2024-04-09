package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Alquiler;

import java.util.List;

public interface AlquilerService {

    Alquiler get(Long id);
    List<Alquiler> getAll();
    void save(Alquiler alquiler);
    void delete(Long id);
}
