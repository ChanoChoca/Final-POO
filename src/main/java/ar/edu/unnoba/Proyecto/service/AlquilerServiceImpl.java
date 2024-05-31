package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Alquiler;
import ar.edu.unnoba.Proyecto.repository.AlquilerRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public Page<Alquiler> getPageWithoutFilter(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return alquilerRepository.findAll(pageRequest);
    }

    @Override
    public Page<Alquiler> getPageWithFilters(int pagina, int tamanioPagina, String titulo, Integer precioMinimo, Integer precioMaximo, Boolean wifi, Boolean buffet) {
        Pageable paginacion = PageRequest.of(pagina, tamanioPagina);

        Specification<Alquiler> especificacion = (raiz, consulta, builder) -> {
            List<Predicate> predicados = new ArrayList<>();

            if (titulo != null && !titulo.isEmpty()) {
                predicados.add(builder.like(raiz.get("titulo"), "%" + titulo + "%"));
            }

            if (precioMinimo != null) {
                predicados.add(builder.greaterThanOrEqualTo(raiz.get("precio"), precioMinimo));
            }

            if (precioMaximo != null) {
                predicados.add(builder.lessThanOrEqualTo(raiz.get("precio"), precioMaximo));
            }

            if (wifi != null) {
                predicados.add(wifi ? builder.isTrue(raiz.get("hayWifi")) : builder.isFalse(raiz.get("hayWifi")));
            }
            if (buffet != null) {
                predicados.add(buffet ? builder.isTrue(raiz.get("hayBufetGratis")) : builder.isFalse(raiz.get("hayBufetGratis")));
            }

            return builder.and(predicados.toArray(new Predicate[0]));
        };

        return alquilerRepository.findAll(especificacion, paginacion);
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
