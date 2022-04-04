package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdminHotel extends Persona implements Serializable {


}
