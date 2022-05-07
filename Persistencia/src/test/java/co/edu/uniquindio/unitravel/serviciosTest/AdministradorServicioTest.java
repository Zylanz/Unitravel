package co.edu.uniquindio.unitravel.serviciosTest;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    public void registrarAdministradorTest(){
        Administrador administrador = new Administrador
                ("4","Pedro","pedro@email.com","12345");
        try {

            Administrador guardado = administradorServicio.registrarAdministrador(administrador);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarAdministradorTest(){
        Administrador administrador = new Administrador
                ("1","Pedro","pedro@email.com","12345");
        try {
            administrador = administradorServicio.registrarAdministrador(administrador);
            administrador.setNombre("Daniel");
            Administrador actualizado = administradorServicio.actualizarAdministrador(administrador);
            Assertions.assertEquals("Daniel", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eliminarAdministradorTest(){
        Administrador administrador = new Administrador
                ("1","Pedro","pedro@email.com","12345");
        try {
            administrador = administradorServicio.registrarAdministrador(administrador);
            administradorServicio.eliminarAdministrador(administrador.getCedula());
            Administrador eliminado = administradorServicio.obtenerAdministrador(administrador.getCedula());
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void listarAdministradoresTest(){
            List<Administrador> administradores = administradorServicio.listarAdministradores();
            administradores.forEach(System.out::println);
    }

    @Test
    public void validarLoginAdministradorTest(){
        Administrador administrador = new Administrador
                ("1","Pedro","pedro@email.com","12345");
        try {
            administrador = administradorServicio.registrarAdministrador(administrador);
            Administrador buscado = administradorServicio.validarLogin("pedro@email.com", "1235");
            Assertions.assertNotNull(buscado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Gestionar Destinos Test

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCiudadTest(){
        Ciudad ciudad = new Ciudad(9, "Popayan");
        try {
            Ciudad guardado = administradorServicio.registrarCiudad(ciudad);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCiudadTest(){
        try {
            Ciudad buscado = administradorServicio.obtenerCiudad(3);
            buscado.setNombre("Caicedonia");
            Ciudad actualizado = administradorServicio.actualizarCiudad(buscado);
            Assertions.assertEquals("Caicedonia", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadTest(){
            Ciudad buscado = administradorServicio.obtenerCiudad(3);
            Assertions.assertNotNull(buscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudadTest(){
        try {
            administradorServicio.eliminarCiudad(1);
            Ciudad eliminado = administradorServicio.obtenerCiudad(1);
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudadesTest(){
        List<Ciudad> ciudades = administradorServicio.listarCiudades();
        System.out.println(ciudades);

    }

    //Gestionar Vuelos Test

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarVueloTest(){
        Ciudad origen = administradorServicio.obtenerCiudad(5);
        Ciudad destino = administradorServicio.obtenerCiudad(2);
        Vuelo vuelo = new Vuelo
        (21, 2.0,LocalDate.of(2022,12,1), LocalTime.of(10,0,0),
                LocalTime.of(11,0,0),"",1,origen,destino);
        try {
            Vuelo guardado = administradorServicio.registrarVuelo(vuelo);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarVueloTest(){
        Vuelo buscado = administradorServicio.obtenerVuelo(2);
        buscado.setAerolinea("PanchitosVuela");
        try {
            Vuelo actualizado = administradorServicio.actualizarVuelo(buscado);
            Assertions.assertEquals("PanchitosVuela", actualizado.getAerolinea());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarVueloTest(){
        try {
            administradorServicio.eliminarVuelo(1);
            Vuelo eliminado = administradorServicio.obtenerVuelo(1);
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarVueloTest(){
        List<Vuelo> vuelos = administradorServicio.listarVuelos();
        System.out.println(vuelos);
    }

    //Gestionar Administradores de Hotel Test

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarAdminHotelTest(){
        AdminHotel adminHotel = new AdminHotel("7", "Daniel", "daniel@email.com", "12345");
        try {
            AdminHotel guardado = administradorServicio.registrarAdminHotel(adminHotel);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdminHotelTest(){
        AdminHotel buscado = administradorServicio.obtenerAdminHotel("4");
        buscado.setNombre("Andres");
        try {
            AdminHotel actualizado = administradorServicio.actualizarAdminHotel(buscado);
            Assertions.assertEquals("Andres", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdminHotelTest(){
        try {
            administradorServicio.eliminarAdminHotel("1");
            AdminHotel eliminado = administradorServicio.obtenerAdminHotel("1");
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarAdminsHotelTest(){
        List<AdminHotel> adminsHotel = administradorServicio.listarAdminsHotel();
        System.out.println(adminsHotel);
    }
}
