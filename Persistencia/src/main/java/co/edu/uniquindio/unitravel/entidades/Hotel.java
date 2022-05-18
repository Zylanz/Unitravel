package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @AllArgsConstructor
@ToString
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

    @ElementCollection
    private List<String> telefonosHotel;

    @OneToMany(mappedBy = "codHotel")
    private List<Foto> fotos;

    @ManyToMany
    private List<Caracteristica> caracteristicas;


    @ManyToOne
    private AdminHotel administrador;

    @ManyToOne
    private Ciudad codCiudad;

    @OneToMany(mappedBy = "hotel")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "comentarioHotel")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hotel")
    private List<Habitacion> habitaciones;


    public Hotel(int codHotel, String nombre, String direccion, double numEstrellas) {
        this.codHotel = codHotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numEstrellas = numEstrellas;
    }
}
