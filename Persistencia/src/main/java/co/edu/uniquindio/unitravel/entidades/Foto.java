package co.edu.uniquindio.unitravel.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Foto {

    @Id
    private int codFoto;

    @Column
    private String ruta;
}
