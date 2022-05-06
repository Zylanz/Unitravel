package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;

import java.util.Optional;

public class AdministradorHotelServicioImpl implements AdministradorHotelServicio
{
    HotelRepo hotelRepo;
    @Override
    public Hotel crearHotel(Hotel h) throws Exception
    {
        Optional<Hotel> buscado= hotelRepo.findById(h.getCodHotel());
        if (buscado.isPresent()){
            throw new Exception("El hotel ya esta registrado");
        }
        return hotelRepo.save(h);
    }

    @Override
    public Hotel obtenerHotel(int codigoHotel) throws Exception
    {
        return hotelRepo.findByCodHotel(codigoHotel).orElse(null);
    }

    @Override
    public Hotel actualizarHotel(Hotel h) throws Exception
    {
        Optional<Hotel> buscado = hotelRepo.findById(h.getCodHotel());
        if (buscado.isEmpty()){
            throw new Exception("El administrador de hotel no se encuentra registrado");
        }
        return hotelRepo.save(h);
    }

    @Override
    public void eliminarHotel(int codigo) throws Exception
    {
        Optional<Hotel> buscado = hotelRepo.findByCodHotel(codigo);
        if (buscado.isEmpty()){
            throw new Exception("El hotel no se encuentra registrado");
        }
        hotelRepo.delete(buscado.get());
    }
}
