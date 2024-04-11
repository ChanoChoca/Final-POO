package ar.edu.unnoba.Proyecto.repository;

import ar.edu.unnoba.Proyecto.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Long> {
}
