package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.CartDetails;

import java.util.List;

public interface CartDetailsService {

    CartDetails get(Long id);
    List<CartDetails> getAll();
    void save(CartDetails cartDetails);
    void delete(Long id);
}
