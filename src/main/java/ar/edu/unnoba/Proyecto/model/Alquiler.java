package ar.edu.unnoba.Proyecto.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table(name="alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="precio")
    private int precio;

    @Min(1)
    @Max(5)
    @Column(name="estrellas")
    private int estrellas;

    @Column(name="cant_habitaciones")
    private int cantidadHabitaciones;

    @Column(name="wifi")
    private boolean hayWifi;

    @Column(name="buffet")
    private boolean hayBufetGratis;

    @Lob //permite trabajar con objetos pesados (imagen)
    @Column(name="imagen")
    private Blob imagen;

    public Alquiler() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public boolean isHayWifi() {
        return hayWifi;
    }

    public void setHayWifi(boolean hayWifi) {
        this.hayWifi = hayWifi;
    }

    public boolean isHayBufetGratis() {
        return hayBufetGratis;
    }

    public void setHayBufetGratis(boolean hayBufetGratis) {
        this.hayBufetGratis = hayBufetGratis;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile file) throws IOException, SQLException {
        byte[] bytes = file.getBytes();
        this.imagen = new javax.sql.rowset.serial.SerialBlob(bytes);
    }
}
