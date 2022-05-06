package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;

import java.util.Optional;

public interface AdministradorHotelServicio
{
    Hotel crearHotel (Hotel h) throws Exception;
    Hotel obtenerHotel (int codigoHotel) throws Exception;
    Hotel actualizarHotel(Hotel h) throws Exception;
    void eliminarHotel (int codigo) throws Exception;
}
