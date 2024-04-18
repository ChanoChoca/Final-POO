package ar.edu.unnoba.Proyecto.repository;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long>, JpaSpecificationExecutor<Alquiler> {
}
