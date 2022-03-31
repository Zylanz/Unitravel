package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {

    @Id
    private int codComentario;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double calificacion;

    @Column(nullable = false)
    private LocalDate fechaComentario;
}
