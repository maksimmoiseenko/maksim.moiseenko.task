package maksim.moiseenko.repositories;

import maksim.moiseenko.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor,Integer> {
        List<Sensor> findByNameContaining(String s);
        List<Sensor> findByTypeContaining(String s);
        List<Sensor> findByUnitContaining(String s);
        List<Sensor> findByLocationContaining(String s);
        List<Sensor> findByDescriptionContaining(String s);
        List<Sensor> findByModelContaining(String s);
}
