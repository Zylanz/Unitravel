package co.edu.uniquindio.unitravel.entidades;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.lang.annotation.Inherited;
import java.util.Map;


@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(length = 200,nullable = false)
    private String nombre;

    @Email
    @Column(length = 200, nullable = false, unique = true)
    private String email;

    @Column(length = 8,nullable = false)
    private String password;

    //@ElementCollection
   // private Map<String, String> telefonos;
}
