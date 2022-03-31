package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad {

    @Id @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCiudad;

    @Column(nullable = false)
    private String nombre;










}
