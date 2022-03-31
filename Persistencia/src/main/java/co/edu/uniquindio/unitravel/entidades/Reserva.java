package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva {


    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codReserva;


    @Column(nullable = false)
    private double valor;


    @Column(nullable = false)
    private MetodoDePago metodoDePago;

    @Column(nullable = false)
    private LocalDate fechaReserva;

    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private LocalDate fechaLlegada;
















}
