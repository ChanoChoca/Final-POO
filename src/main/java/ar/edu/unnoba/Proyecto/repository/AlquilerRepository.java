package ar.edu.unnoba.Proyecto.repository;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import ar.edu.unnoba.Proyecto.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    Page<Alquiler> findAll(Pageable pageable);
    Page<Alquiler> findAlquilerByTituloContainingIgnoreCase(String title, Pageable pageable);

    Page<Alquiler> findByTituloContainingIgnoreCaseAndPrecioBetween(String title, Integer minPrice, Integer maxPrice, PageRequest pageRequest);

    Page<Alquiler> findByTituloContainingIgnoreCaseAndPrecioGreaterThanEqual(String title, Integer minPrice, PageRequest pageRequest);

    Page<Alquiler> findByTituloContainingIgnoreCaseAndPrecioLessThanEqual(String title, Integer maxPrice, PageRequest pageRequest);

    Page<Alquiler> findByTituloContainingIgnoreCase(String title, PageRequest pageRequest);

    Page<Alquiler> findByPrecioBetween(Integer minPrice, Integer maxPrice, PageRequest pageRequest);
}
