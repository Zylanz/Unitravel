package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codCaracteristica;

    @Column(nullable = false,length = 100)
    private String descripcion;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Habitacion> codHabitaciones;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Hotel> codHotel;

}
