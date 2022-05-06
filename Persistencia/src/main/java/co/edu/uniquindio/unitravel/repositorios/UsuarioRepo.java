package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo  extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u")
    List<Usuario> listarUsuarios();

    @Query("select u from Usuario u where u.email = :email")
    Optional<Usuario> buscarPorEmail( @Param("email") String email);

    List<Usuario> findAllUsuarioByNombre (String nombre);

    Optional<Usuario> findUsuarioByEmailAndPassword(String email, String pass);

    //Buscar destinos
    @Query("select c.nombre from Ciudad c")
    List<String> ListarDestinos ();

    //Buscar Hoteles
    @Query("select h.nombre from Hotel h")
    List<String> ListarHoteles ();

    //Buscar hotel por ciudad
    @Query("select h.nombre from Hotel h where h.codCiudad = :codC")
    List<String> ListarHotelesPorCiudad(int codC);

    @Query("select r from Usuario u join u.reservas r" )
    List<Reserva> listarReservas();

    Optional<Usuario> findByEmail(String email);
}
