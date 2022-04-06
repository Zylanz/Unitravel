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
public class Usuario implements Serializable {

    @Id
    private int codUsuario;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private boolean afiliado;

    @OneToMany(mappedBy = "codUsuario")
    private List<Comentario> comentarios;






}
