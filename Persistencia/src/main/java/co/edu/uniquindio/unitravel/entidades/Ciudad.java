package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCiudad;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "codCiudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "codOrigen")
    private List<Ciudad> origenVuelos;

    @OneToMany(mappedBy = "codDestino")
    private List<Ciudad> destinoVuelos;







}
