package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Ciudad implements Serializable {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codCiudad;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "codCiudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "codOrigen")
    private List<Vuelo> origenVuelos;

    @OneToMany(mappedBy = "codDestino")
    private List<Vuelo> destinoVuelos;

    public Ciudad(int codCiudad, String nombre) {
        this.codCiudad = codCiudad;
        this.nombre = nombre;
    }
}
