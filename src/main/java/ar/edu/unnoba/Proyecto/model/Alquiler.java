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

<<<<<<< HEAD
    @Column(name="titulo")
    private String titulo;
=======
    @Column(name="nombre")
    private int nombre;
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0

    @Column(name="precio")
    private int precio;

    @Min(1)
    @Max(5)
<<<<<<< HEAD
    @Column(name="estrellas")
=======
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
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

<<<<<<< HEAD
    @OneToOne
    @JoinColumn(name="cart_details_id")
    private CartDetails cartDetails;

=======
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
    public Alquiler() {
    }

    public Long getId() {
        return id;
    }

<<<<<<< HEAD
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
=======
    public void setId(Long id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
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

<<<<<<< HEAD
    public CartDetails getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }
=======
>>>>>>> c427349071f561d944152b3cf86e126fd43c88e0
}
