package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.List;

public interface AlquilerService {

    Alquiler get(Long id);
    List<Alquiler> getAll();
    void save(Alquiler alquiler);
    void delete(Long id);

    Page<Alquiler> getPage(Pageable pageable);
    Page<Alquiler> getPageWithTitleFilter(int page, int size, String title);
    byte[] getImageBytes(Long id) throws SQLException;
}
