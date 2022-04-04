package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;


    @Column(nullable = false, length = 100)
    private String nombre;


    @Column(nullable = false, length = 1000)
    private String direccion;

    @Column(nullable = false)
    private int estrellas;

    //Integer = codigo del hotel, String = ruta de la foto
    @ElementCollection
    private Map<Integer, String> foto;
}
