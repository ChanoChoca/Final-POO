package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import ar.edu.unnoba.Proyecto.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlquilerServiceImpl implements AlquilerService{

    private final AlquilerRepository alquilerRepository;

    @Autowired
    public AlquilerServiceImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Override
    public Alquiler get(Long id) {
        return alquilerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Alquiler> getAll() {
        return alquilerRepository.findAll();
    }

    @Override
    public void save(Alquiler alquiler) {
        alquilerRepository.save(alquiler);
    }

    @Override
    public void delete(Long id) {
        alquilerRepository.deleteById(id);
    }

    @Override
    public Page<Alquiler> getPage(Pageable pageable) {
        return alquilerRepository.findAll(pageable);
    }

    @Override
    public Page<Alquiler> getPageWithTitleFilter(int page, int size, String title) {

        PageRequest pageRequest = PageRequest.of(page, size);
        if (title != null) {
            return alquilerRepository.findByTituloContainingIgnoreCase(title, pageRequest);
        } else {
            return getPage(pageRequest);
        }
    }

    @Override
    public Page<Alquiler> getPageWithTitleAndPriceFilter(int page, int size, String title, Integer minPrice, Integer maxPrice) {
        PageRequest pageRequest = PageRequest.of(page, size);

        if (title != null) {
            if (minPrice != null && maxPrice != null) {
                // Filtrar por título y rango de precios
                return alquilerRepository.findByTituloContainingIgnoreCaseAndPrecioBetween(title, minPrice, maxPrice, pageRequest);
            } else if (minPrice != null) {
                // Filtrar por título y precio mínimo
                return alquilerRepository.findByTituloContainingIgnoreCaseAndPrecioGreaterThanEqual(title, minPrice, pageRequest);
            } else { // if (maxPrice != null)
                // Filtrar por título y precio máximo
                return alquilerRepository.findByTituloContainingIgnoreCaseAndPrecioLessThanEqual(title, maxPrice, pageRequest);
            }
        } else {
            return alquilerRepository.findAll(pageRequest);
        }
    }

    @Override
    public byte[] getImageBytes(Long id) throws SQLException {
        Alquiler alquiler = alquilerRepository.findById(id).orElse(null);
        if (alquiler != null) {
            return alquiler.getImagen().getBytes(1, (int) alquiler.getImagen().length());
        } else {
            System.out.println("Imagen no disponible para el alquiler con ID: " + id);
            return null;
        }
    }
}
