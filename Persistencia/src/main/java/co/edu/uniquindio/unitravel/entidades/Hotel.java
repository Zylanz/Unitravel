package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codHotel;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length =100)
    private String direccion;

    @Column(nullable = false)
    @Positive
    private double numEstrellas;

    //@ElementCollection
    //private Map<String, String> telefonosHotel;

    @OneToMany(mappedBy = "codHotel")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "codHotel")
    private List<Caracteristicas> caracteristicas;

    @ManyToOne
    private Ciudad codCiudad;

    @ManyToMany(mappedBy = "hoteles")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "comentariosHotel")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;

}
