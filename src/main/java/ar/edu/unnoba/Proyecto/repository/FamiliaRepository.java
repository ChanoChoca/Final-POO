package ar.edu.unnoba.Proyecto.repository;

import ar.edu.unnoba.Proyecto.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long>{

    @Query("SELECT DISTINCT f.apellido FROM Familia f")
    List<String> findDistinctByApellido();

    @Query ("SELECT DISTINCT f.apellido FROM Familia f WHERE f.apellido LIKE :apellido%")
    List<String> findDistinctApellidosByApellido(@Param("apellido")String apellido);

    List<Familia> findByApellido(String apellido);

}
