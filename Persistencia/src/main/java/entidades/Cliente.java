package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    @Column(nullable = false)
    private boolean isAfiliado;
}
