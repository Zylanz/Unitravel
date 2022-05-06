package co.edu.uniquindio.unitravel.serviciosTest;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdminHotelServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class AdminHotelServicioTest {

    @Autowired
    private AdminHotelServicio adminHotelServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarAdminHotelTest(){
        AdminHotel adminHotel = new AdminHotel
                ("7","Gabriel", "gabo@email.com","12345");
        try {
            AdminHotel guardado = adminHotelServicio.registrarAdminHotel(adminHotel);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdminHotelTest(){
        AdminHotel adminHotel = adminHotelServicio.obtenerAdminHotel("1");
        adminHotel.setNombre("Camilo");
        try {
            AdminHotel actualizado = adminHotelServicio.actualizarAdminHotel(adminHotel);
            Assertions.assertEquals("Camilo", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdminHotelTest(){
        AdminHotel adminHotel = adminHotelServicio.obtenerAdminHotel("3");
        Assertions.assertNotNull(adminHotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdminHotelTest(){
        try {
            adminHotelServicio.eliminarAdminHotel("2");
            AdminHotel eliminado = adminHotelServicio.obtenerAdminHotel("2");
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdminsHotelTest(){
        List<AdminHotel> adminsHotel = adminHotelServicio.listarAdminsHotel();
        adminsHotel.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void validarLoginAdminHotelTest(){
        try {
            AdminHotel buscado = adminHotelServicio.validarLoginAdminHotel("pablo5@email.com","pablo123");
            Assertions.assertNotNull(buscado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Gestionar Hoteles


    @Test
    @Sql("classpath:dataset.sql")
    public void registrarHotelTest(){
        Hotel hotel = new Hotel
                (25, "Hotel25", "Direccion25", 0);
        try {
            Hotel guardado = adminHotelServicio.registrarHotel(hotel);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHotelTest(){
        Hotel hotel = adminHotelServicio.obtenerHotel(1);
        hotel.setNombre("HotelNuevo");
        try {
            Hotel actualizado = adminHotelServicio.actualizarHotel(hotel);
            Assertions.assertEquals("HotelNuevo", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarHotelTest(){
        try {
            adminHotelServicio.eliminarHotel(3);
            Hotel eliminado = adminHotelServicio.obtenerHotel(3);
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelTest(){
        Hotel hotel = adminHotelServicio.obtenerHotel(4);
        Assertions.assertNotNull(hotel);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesTest(){
        List<Hotel> hoteles = adminHotelServicio.listarHoteles();
        hoteles.forEach(System.out::println);
    }




}
