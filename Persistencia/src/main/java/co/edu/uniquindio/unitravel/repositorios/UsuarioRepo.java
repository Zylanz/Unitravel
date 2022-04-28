package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo  extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u")
    List<Usuario> listarUsuarios();

    @Query("select u from Usuario u where u.email = :email")
    Usuario buscarPorEmail( @Param("email") String email);

    List<Usuario> findAllUsuarioByNombre (String nombre);

    Usuario findUsuarioByEmailAndPassword(String email, String pass);
}
