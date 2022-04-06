package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {

    @Id
    private int codHabitacion;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int capacidad;

    @ElementCollection
    private List<Cama> cama;

    @OneToMany(mappedBy = "codHabitacion;")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "codHabitacion")
    private List<Caracteristica> caracteristicas;







}
