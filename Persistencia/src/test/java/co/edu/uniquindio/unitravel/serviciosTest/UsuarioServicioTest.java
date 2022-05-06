package co.edu.uniquindio.unitravel.serviciosTest;

import co.edu.uniquindio.unitravel.servicios.EmailService;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicioImpl;
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
    private EmailService emailService;


    @Test
    public void enviarCorreoTest(){
        boolean estado = emailService.enviarEmail("Prueba", "Este es un mensaje","nmurilloc@uqvirtual.edu.co");

    }





}
