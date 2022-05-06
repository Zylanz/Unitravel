package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDateTime fechaComentario;

    @ManyToOne
    private Usuario cedulaUsuario;

    @ManyToOne
    private Hotel comentariosHotel;

    public Comentario(String descripcion, double calificacion, LocalDate fechaComentario, Usuario cedulaUsuario, Hotel comentariosHotel) {
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.fechaComentario = LocalDateTime.now();
        this.cedulaUsuario = cedulaUsuario;
        this.comentariosHotel = comentariosHotel;
    }
}
