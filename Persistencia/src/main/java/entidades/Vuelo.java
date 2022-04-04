package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime horaDespegue;

    @Future
    @Column(nullable = false)
    private LocalDate horaAterrizaje;

    @Column(nullable = false)
    private String Aerolinea;

    //Generado Aleatoriamente
    @Column(nullable = false)
    private int silla;


}
