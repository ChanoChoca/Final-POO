package ar.edu.unnoba.Proyecto.repository;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    Page<Alquiler> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
    Page<Alquiler> findByTituloContainingIgnoreCaseAndPrecioBetween(String titulo, Integer precioMinimo, Integer precioMaximo, PageRequest pageRequest);
    Page<Alquiler> findByTituloContainingIgnoreCaseAndPrecioGreaterThanEqual(String titulo, Integer precioMinimo, PageRequest pageRequest);
    Page<Alquiler> findByTituloContainingIgnoreCaseAndPrecioLessThanEqual(String titulo, Integer precioMaximo, PageRequest pageRequest);
    Page<Alquiler> findByPrecioBetween(Integer precioMinimo, Integer precioMaximo, PageRequest pageRequest);

}
