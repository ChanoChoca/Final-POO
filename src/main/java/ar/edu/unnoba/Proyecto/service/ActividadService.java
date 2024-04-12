package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Actividad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
import java.util.List;

public interface ActividadService {
    Actividad get(Long id);
    List<Actividad> getAll();
    void save(Actividad actividad);
    void delete(Long id);

    Page<Actividad> getPage(Pageable pageable);
<<<<<<< HEAD
    Page<Actividad> getPageWithTitleFilter(int page, int size, String title);
    byte[] getImageBytes(Long id) throws SQLException;
}
=======

    Page<Actividad> getPageWithTitleFilter(int page, int size, String title);
}
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
