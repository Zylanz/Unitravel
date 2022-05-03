package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer>
{
    @Query("select r from Reserva r where r.fechaReserva = :fecha")
    Reserva comprobarFecha(String fecha);

    List<Reserva> findAllByFechaReserva(LocalDate fecha);
}
