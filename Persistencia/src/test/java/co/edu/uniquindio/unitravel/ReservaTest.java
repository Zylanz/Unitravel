package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest
{
    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarFecha()
    {
        LocalDate fecha= LocalDate.of(2022,05,24);
        List<Reserva> reservas=reservaRepo.findAllByFechaReserva(fecha);
        Reserva reservaObtenida=null;

        for (Reserva r: reservas)
        {
            boolean centinela=false;

            if (r.getFechaReserva().equals(fecha)&&centinela==false)
            {
                centinela=true;
                reservaObtenida=r;
            }
        }

        Assertions.assertNotNull(reservaObtenida);
    }
}
