package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity @Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codComentario;

    @Lob
    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Positive
    private double calificacion;

    @Column(nullable = false)
    private LocalDate fechaComentario;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Hotel comentarioHotel;


}
