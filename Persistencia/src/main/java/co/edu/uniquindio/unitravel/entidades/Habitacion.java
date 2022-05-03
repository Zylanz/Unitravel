package co.edu.uniquindio.unitravel.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion implements Serializable {

    @Id
    private int codHabitacion;

    @Column(nullable = false)
    @Positive
    private int numero;

    @Column(nullable = false)
    @Positive
    private double precio;

    @Column(nullable = false)
    @Positive
    private int capacidad;

    @ElementCollection
    private List<Cama> camas;

    @OneToMany(mappedBy = "codHabitacion")
    private List<Foto> fotos;

    @ManyToMany
    private List<Caracteristica> caracteristicas;

    @ManyToOne
    private Hotel hotel;

}
