package co.edu.uniquindio.unitravel.repositorios;


import co.edu.uniquindio.unitravel.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer>
{
    Optional<Ciudad> findByNombre(String nombreCiudad);
}
