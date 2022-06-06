package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicasRepo extends JpaRepository<Caracteristica, Integer> {

    List<Caracteristica> findAllByTipo(int tipo);

}
