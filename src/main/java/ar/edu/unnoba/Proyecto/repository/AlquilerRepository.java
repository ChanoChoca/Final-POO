package ar.edu.unnoba.Proyecto.repository;

import ar.edu.unnoba.Proyecto.model.Alquiler;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long>, JpaSpecificationExecutor<Alquiler> {
=======
import ar.edu.unnoba.Proyecto.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    Page<Alquiler> findAll(Pageable pageable);
    Page<Alquiler> findAlquilerByTituloContainingIgnoreCase(String title, Pageable pageable);
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
}
