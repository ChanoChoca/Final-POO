package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import org.springframework.data.domain.Page;

import java.sql.SQLException;
import java.util.List;

public interface AlquilerService {

    Alquiler get(Long id);
    List<Alquiler> getAll();
    void save(Alquiler alquiler);
    void delete(Long id);

    Page<Alquiler> getPageWithoutFilter(int page, int size);
    byte[] getImageBytes(Long id) throws SQLException;
    Page<Alquiler> getPageWithFilters(int i, int size, String title, Integer minPrice, Integer maxPrice, Boolean wifi, Boolean bufet);
}
