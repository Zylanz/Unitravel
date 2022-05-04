package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.AdminHotel;
import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminHotelRepo extends JpaRepository<AdminHotel, String>
{

    Administrador findByEmailAndPassword(String email, String password);
    Administrador findByEmail(String email);

    Administrador findByCedula(String cedula);

}
