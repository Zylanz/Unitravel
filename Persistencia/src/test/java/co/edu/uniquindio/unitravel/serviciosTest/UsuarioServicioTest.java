package co.edu.uniquindio.unitravel.serviciosTest;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuarioTest(){
        Usuario usuario = new Usuario
                ("10","Camilo","camilo@email.com","12345");
        try {
            Usuario guardado = usuarioServicio.registrarUsuario(usuario);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuarioTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("1");
        try {
            Usuario actualizado = usuarioServicio.actualizarUsuario(usuario);
            actualizado.setNombre("Andres");
            Assertions.assertEquals("Andres", actualizado.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuarioTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("4");
        Assertions.assertNotNull(usuario);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuarioTest(){
        try {
           usuarioServicio.eliminarUsuario("6");
           Usuario eliminado = usuarioServicio.obtenerUsuario("6");
           Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarioTest(){
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        usuarios.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void validadLoginUsuarioTest(){
        try {
            Usuario usuario = usuarioServicio.login("mikasa666@gmail.com","pass6");
            Assertions.assertNotNull(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void realizarReservaTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("1");
        Hotel hotel = new Hotel();
        Reserva reserva = new Reserva
                (7, 5, MetodoPago.CREDITO,LocalDate.of(2022,7,9), LocalDate.of(2022,5,24),
                        LocalDate.of(2022,6,18),new ArrayList<>(),hotel,new ArrayList<>(),usuario);
        try {
            Reserva guardada = usuarioServicio.realizarReserva(hotel,reserva,usuario,5);
            Assertions.assertNotNull(guardada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarReservaTest(){
        try {
            usuarioServicio.eliminarReserva(2);
            Reserva eliminado = usuarioServicio.obtenerReserva(2);
            Assertions.assertNull(eliminado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarReservaTest(){
        try {
            Reserva reserva = usuarioServicio.obtenerReserva(1);
            reserva.setValor(6.0);
            Reserva actualizada = usuarioServicio.actualizarReserva(reserva);
            Assertions.assertEquals(6.0, actualizada.getValor());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservaTest(){
        List<Reserva> reservas = usuarioServicio.listarReservas();
        reservas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void isAfiliadoTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("5");
        try {
            usuario.setAfiliado(false);
            boolean isAfiliado = usuarioServicio.isAfiliado(usuario);
            Assertions.assertEquals(false, isAfiliado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesPorCiudadTest(){
        try {
            List<Hotel> hoteles = usuarioServicio.listarHotelesPorCiudad("Cali");
            hoteles.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void recuperarPassTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("6");
        try {
            usuarioServicio.recuperarPassword(usuario.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agregarComentarioTest(){
        Usuario usuario = usuarioServicio.obtenerUsuario("1");
        Hotel hotel;
    {
        try {
            hotel = usuarioServicio.obtenerReserva(1).getHotel();
            Comentario comentario = new Comentario(100,
                    "Este es el comentario", 2, LocalDate.of(2022, 3, 15),
                    usuario, hotel);
            Comentario agregado = usuarioServicio.agregarComentario(comentario);
            Assertions.assertNotNull(agregado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

}
