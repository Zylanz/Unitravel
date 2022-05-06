package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    @Positive
    private double costo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime horaDespegue;

    @Future
    @Column(nullable = false)
    private LocalTime horaAterrizaje;

    @Column(nullable = false)
    private String aerolinea;

    //Generado Aleatoriamente
    @Column(nullable = false)
    private int silla;

    @ManyToOne
    private Ciudad codOrigen;

     @ManyToOne
     private Ciudad codDestino;

}
