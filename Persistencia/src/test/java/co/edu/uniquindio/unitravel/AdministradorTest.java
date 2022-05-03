package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    //Loguearse
    @Test
    @Sql("classpath:dataset.sql")
    public void login()
    {
        Administrador admin = administradorRepo.findByEmailAndPassword("pabloadmin1@email.com", "pablo123");

        Assertions.assertEquals("pabloadmin1", admin.getNombre());
    }


    @Test
    public void agregarCiudad(){



    }


}
