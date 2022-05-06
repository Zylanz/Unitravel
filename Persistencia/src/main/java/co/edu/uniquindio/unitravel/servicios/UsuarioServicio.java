package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    void eliminarUsuario(String cedula) throws Exception;

    List<Usuario> listarUsuarios();

    List<Reserva> listarReservas(Usuario u);

    List<Comentario> agregarComentario(Comentario c);

    // Gestionar reserva
    Reserva reservar() throws Exception;

    Reserva actualizarReserva() throws Exception;

    void eliminarReserva() throws Exception;

    List<Reserva> reservasUsuario();

    Usuario recuperarContrasena()throws Exception;
}
