package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {


    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Ciudad> ciudades = ciudadRepo.findAll();
        System.out.println(ciudades);
    }
}
