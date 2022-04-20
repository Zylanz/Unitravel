package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Entity
@Setter @Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int codFoto;

    @Column(nullable = false)
    private String ruta;

    @ManyToOne
    private Hotel codHotel;

    @ManyToOne
    private Habitacion codHabitacion;
}