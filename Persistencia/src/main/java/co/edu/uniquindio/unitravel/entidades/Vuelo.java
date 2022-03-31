package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo {

    @Id
    private int codVuelo;

    @Column(nullable = false)
    private LocalTime horaSalida;

    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private LocalDate fechaLlegada;
}
