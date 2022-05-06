package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer>
{
    @Query("select r from Reserva r where r.fechaReserva = :fecha")
    Reserva comprobarFecha(LocalDate fecha);

    List<Reserva> findAllByFechaReserva(LocalDate fecha);

    @Query("select r from Reserva r join r.hoteles h where r.fechaReserva = :fecha and h.codHotel = :cod")
    Optional<Reserva> buscarReservaPorHotel(LocalDate fecha, int cod);
}
