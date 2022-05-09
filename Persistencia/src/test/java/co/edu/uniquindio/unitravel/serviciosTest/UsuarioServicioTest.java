package co.edu.uniquindio.unitravel.serviciosTest;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import co.edu.uniquindio.unitravel.servicios.EmailService;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EmailService emailService;


    @Test
    public void enviarCorreoTest(){
        boolean estado = emailService.enviarEmail("Prueba", "Este es un mensaje","nmurilloc@uqvirtual.edu.co");

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuarioTest() throws Exception {
        Usuario u = new Usuario("6", "Nicolas", "nicolas@email.com", "pass");
        Usuario  usuarioRegistrado = usuarioServicio.registrarUsuario(u);

        Assertions.assertNotNull(usuarioRegistrado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest() throws Exception {
        Usuario u = usuarioServicio.login("a@mail.com","pass1");



    }



}
