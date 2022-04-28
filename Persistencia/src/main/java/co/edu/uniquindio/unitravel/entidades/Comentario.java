package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codComentario;

    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(nullable = false)
    @Positive
    private double calificacion;

    @Column(nullable = false)
    private LocalDate fechaComentario;

    @ManyToOne
    private Usuario cedulaUsuario;

    @ManyToOne
    private Hotel comentariosHotel;
}
