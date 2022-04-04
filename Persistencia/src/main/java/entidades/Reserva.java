package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column
    private LocalDateTime fechaLlegada;

    @Future
    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private LocalDate fechaReserva;

    @Column(nullable = false)
    private double valorReserva;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;


}
