package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Silla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SillaRepo extends JpaRepository<Silla, Integer>
{
    Optional<Silla> findByCodSilla(int codigoSilla);
}
