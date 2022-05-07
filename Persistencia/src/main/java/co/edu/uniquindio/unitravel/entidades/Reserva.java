package co.edu.uniquindio.unitravel.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity @Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {


    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codReserva;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private MetodoPago metodoDePago;

    @Column(nullable = false)
    private LocalDate fechaReserva;

    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private LocalDate fechaLlegada;

    @ManyToMany(mappedBy = "reservas")
    private List<Silla> Sillas;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Usuario usuario;














}
