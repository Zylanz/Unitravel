package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Habitacion implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int numero;

    @Column(nullable = false)
    @Positive
    private double precio;

    @Column(nullable = false)
    @Positive
    private int capacidad;



    //Integer = codigo del hotel, String = ruta de la foto
    @ElementCollection
    private Map<Integer, String> foto;

    @Enumerated(EnumType.STRING)
    private Cama cama;
}
