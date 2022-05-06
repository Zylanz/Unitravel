package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer>
{
    Optional<Hotel> findByCodHotel(int codigoHotel);

    @Query("select h from Hotel h where h.codCiudad = :ciudad")
    List<Hotel> buscarHotelPorCiudad (int ciudad);
}
