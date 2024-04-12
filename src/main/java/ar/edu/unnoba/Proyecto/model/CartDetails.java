package ar.edu.unnoba.Proyecto.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="cart_details")
public class CartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "desde", nullable = false)
    private LocalDate desde;

    @Column(name = "hasta", nullable = false)
    private LocalDate hasta;

    @Column(name= "total", nullable = false)
    private int total;

    public CartDetails() {
    }

    public CartDetails(LocalDate desde, LocalDate hasta, int total) {
        this.desde = desde;
        this.hasta = hasta;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
