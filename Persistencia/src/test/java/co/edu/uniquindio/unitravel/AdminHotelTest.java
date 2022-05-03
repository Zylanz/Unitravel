package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdminHotelTest {

    @Autowired
    private AdminHotelRepo adminHotelRepo;

    @Test
    public void registrar(){
        AdminHotel adminHotel = new AdminHotel("12345","pablo@email.com","pablo","pablo123");
        AdminHotel adminHotelSaved = adminHotelRepo.save(adminHotel);

        Assertions.assertNotNull(adminHotelSaved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<AdminHotel> adminsHotel = adminHotelRepo.findAll();
        System.out.println(adminsHotel);

    }







}
