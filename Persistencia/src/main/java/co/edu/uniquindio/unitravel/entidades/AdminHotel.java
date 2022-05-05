package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter@Setter
public class AdminHotel extends Persona implements Serializable {

    @OneToMany(mappedBy = "administrador")
    private List<Hotel> hoteles;

    public AdminHotel(String cedula, String nombre, @Email String email, String password) {
        super(cedula, nombre, email, password);
    }
}

