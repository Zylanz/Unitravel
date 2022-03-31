package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel {

    @Id
    private int codHotel;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private double numEstrellas;







}
