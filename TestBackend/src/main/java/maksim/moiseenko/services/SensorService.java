package maksim.moiseenko.services;

import maksim.moiseenko.models.Sensor;
import maksim.moiseenko.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository){
        this.sensorRepository=sensorRepository;
    }

    public List<Sensor> search(String substring){
        List<Sensor> result=new ArrayList<>(sensorRepository.findByNameContainingOrTypeContainingOrUnitContainingOrLocationContainingOrDescriptionContainingOrModelContaining(substring,
                substring,substring,substring,substring,substring));

        return result.stream().distinct().collect(Collectors.toList());

    }
    public Sensor findOneById(int id){
        return sensorRepository.findOne(id);
    }
    public void deleteById(int id){
        sensorRepository.delete(id);
    }
    public void save(Sensor sensor){
       sensorRepository.save(sensor);
    }
    public List<Sensor> getAllSensors(){
        return sensorRepository.findAll();
    }
}
