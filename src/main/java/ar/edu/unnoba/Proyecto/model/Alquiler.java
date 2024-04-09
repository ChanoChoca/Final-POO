package ar.edu.unnoba.Proyecto.model;

import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private int nombre;

    @Column(name="precio")
    private int precio;

    @Min(1)
    @Max(5)
    private int estrellas;

    @Column(name="cant_habitaciones")
    private int cantidadHabitaciones;

    @Column(name="wifi")
    private boolean hayWifi;

    @Column(name="buffet")
    private boolean hayBufetGratis;

}
