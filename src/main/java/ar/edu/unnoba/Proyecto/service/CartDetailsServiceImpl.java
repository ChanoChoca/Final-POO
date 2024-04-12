package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.CartDetails;
import ar.edu.unnoba.Proyecto.repository.CartDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailsServiceImpl implements CartDetailsService{

    private final CartDetailsRepository cartDetailsRepository;

    @Autowired
    public CartDetailsServiceImpl(CartDetailsRepository cartDetailsRepository) {
        this.cartDetailsRepository = cartDetailsRepository;
    }

    @Override
    public CartDetails get(Long id) {
        return cartDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<CartDetails> getAll() {
        return cartDetailsRepository.findAll();
    }

    @Override
    public void save(CartDetails cartDetails) {
        cartDetailsRepository.save(cartDetails);
    }

    @Override
    public void delete(Long id){
        cartDetailsRepository.deleteById(id);
    }
}
