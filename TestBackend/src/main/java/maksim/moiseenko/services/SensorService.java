package maksim.moiseenko.services;

import maksim.moiseenko.models.Sensor;
import maksim.moiseenko.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {
    final private SensorRepository sensorRepository;
    @Autowired
    public SensorService(SensorRepository sensorRepository){
        this.sensorRepository=sensorRepository;
    }


    public List<Sensor> search(String substring){
        List<Sensor> result= new ArrayList<>();
        List<Sensor> list =sensorRepository.findAll();
        boolean isAdded;
        try{
            for(Sensor sensor: list){
                isAdded=false;
                if(sensor.getModel()!=null){
                    if(sensor.getModel().contains(substring)){
                        result.add(sensor);
                        isAdded=true;
                    }
                }
                if(!isAdded && sensor.getName()!=null){
                    if(sensor.getName().contains(substring)) {
                        result.add(sensor);
                        isAdded=true;
                    }
                }
                if(!isAdded && sensor.getType()!=null){
                    if(sensor.getType().contains(substring)) {
                        result.add(sensor);
                        isAdded=true;
                    }
                }
                if(!isAdded && sensor.getUnit()!=null){
                    if(sensor.getUnit().contains(substring)) {
                        result.add(sensor);
                        isAdded=true;
                    }
                }
                if((sensor.getRangeFrom()+"").contains(substring)
                        ||(sensor.getRangeTo()+"").contains(substring)){
                    result.add(sensor);
                    isAdded=true;
                }
                if(!isAdded && sensor.getDescription()!=null){
                    if(sensor.getDescription().contains(substring)) {
                        result.add(sensor);
                        isAdded=true;
                    }
                }
                if(!isAdded && sensor.getLocation()!=null){
                    if(sensor.getLocation().contains(substring))
                        result.add(sensor);
                }

            }
        }
        finally {
            return result;
        }
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
