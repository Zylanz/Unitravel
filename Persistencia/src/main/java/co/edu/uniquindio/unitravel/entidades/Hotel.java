package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {

    @Id
    private int codHotel;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private double numEstrellas;

    @OneToMany(mappedBy = "codHotel")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "codHotel")
    private List<Caracteristica> caracteristicas;

    @ManyToOne
    private Ciudad codCiudad;


}
