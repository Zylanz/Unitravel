package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion {

    @Id
    private int codHabitacion;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int capacidad;








}
