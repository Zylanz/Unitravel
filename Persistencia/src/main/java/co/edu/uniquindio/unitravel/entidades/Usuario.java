package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter@Setter
@ToString(callSuper = true,onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {

    @Column(nullable = true)
    private boolean isAfiliado;

    @Column(unique = true,length = 10)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codUsuario;

    @OneToMany(mappedBy = "codUsuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    public Usuario(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}
