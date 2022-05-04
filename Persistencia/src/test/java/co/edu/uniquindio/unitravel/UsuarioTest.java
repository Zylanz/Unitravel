package co.edu.uniquindio.unitravel;


import ch.qos.logback.core.net.SyslogOutputStream;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;



    @Test
    public void registrar(){

        Usuario user = new Usuario("1243","Pepe", "pepe@mail.com","234");
        Usuario userSaved = usuarioRepo.save(user);

        Assertions.assertNotNull(userSaved);
    }
    @Test
    public void eliminar(){

        Usuario user = new Usuario("1243","Pepe", "pepe@mail.com","234");
        Usuario userSaved = usuarioRepo.save(user);

        usuarioRepo.delete(userSaved);

        Usuario userFound = usuarioRepo.findById("1243").orElse(null);
        Assertions.assertNull(userFound);
    }


    @Test
    public void actualizar(){

        Usuario user = new Usuario("1243","Pepe", "pepe@mail.com","234");
        Usuario userSaved = usuarioRepo.save(user);
        userSaved.setPassword("ac124");

        usuarioRepo.save(userSaved);

        Usuario userFound = usuarioRepo.findById("1243").orElse(null);
        Assertions.assertEquals("ac124",userFound.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        System.out.println(usuarios);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPorCorreoContraseña(){

        Usuario userFound = usuarioRepo.findUsuarioByEmailAndPassword
                ("a@mail.com","pass1");
        Assertions.assertEquals("cedula1",userFound.getCedula());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarDestinos(){

        List<String> ciudades = usuarioRepo.ListarDestinos();

        System.out.println(ciudades);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void loggin()
    {
        String email="a@mail.com";
        String pass="pass1";

        Usuario usuarioEncontrado=usuarioRepo.findUsuarioByEmailAndPassword(email,pass);

        Assertions.assertNotNull(usuarioEncontrado);
    }

}
