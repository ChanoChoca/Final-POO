package ar.edu.unnoba.Proyecto.service;

import ar.edu.unnoba.Proyecto.model.Familia;
import ar.edu.unnoba.Proyecto.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unnoba.Proyecto.model.Actividad;
import ar.edu.unnoba.Proyecto.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;



import java.sql.SQLException;
import java.util.List;

@Service
public class FamiliaServiceImpl implements FamiliaService{

    private final FamiliaRepository familiaRepository;

    @Autowired
    public FamiliaServiceImpl(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Override
    public List<String> getApellidoSinRepetir(){
        return familiaRepository.findDistinctByApellido();
    }
    @Override
    public List<String> getApellidosFiltrados(String apellido){
        return familiaRepository.findDistinctApellidosByApellido(apellido);
    }
    @Override
    public List<Familia> getFamiliaPorApellido(String apellido){
        return familiaRepository.findByApellido(apellido);
    }


}
