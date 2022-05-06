package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;

    Usuario actualizarUsuario(Usuario u) throws Exception;

    void eliminarUsuario(String cedula) throws Exception;

    List<Usuario> listarUsuarios();

    Usuario login (String email, String pass) throws Exception;

    Reserva realizarReserva(Hotel h, Reserva r, Usuario u, int cantidadSillas) throws Exception;

    void eliminarReserva(int codigoReserva) throws Exception;

    Reserva actualizarReserva(Reserva r) throws Exception;

    List<Reserva> listarReservas();
    boolean isAfiliado(Usuario u) throws Exception;

    List<Hotel> listarHotelesPorCiudad(String nombreCiudad) throws Exception;

    Reserva obtenerReserva(int codigoReserva) throws Exception;
    void recuperarPassword(String email) throws Exception;

    Comentario agregarComentario(Comentario c) throws Exception;
}
