package maksim.moiseenko.controllers;

import maksim.moiseenko.dto.SensorDto;
import maksim.moiseenko.models.Sensor;
import maksim.moiseenko.models.Type;
import maksim.moiseenko.models.Unit;
import maksim.moiseenko.repositories.SensorRepository;
import maksim.moiseenko.repositories.TypeRepository;
import maksim.moiseenko.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class SensorControllers {
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private UnitRepository unitRepository;
    @GetMapping("/types")
    public List<Type> getTypes(){
        return typeRepository.findAll();
    }
    @GetMapping("/units")
    public List<Unit> getUnits(){
        return unitRepository.findAll();
    }
    @GetMapping("/sensors")
    public List<Sensor> getSensors(){
        return sensorRepository.findAll();
    }
    @GetMapping("/sensor/{id}")
    public Sensor getSensor(@PathVariable int id){
        return sensorRepository.findOne(id);
    }
    @GetMapping("/sensors/search/{substring}")
    public List<Sensor> getSensorsSearch(@PathVariable String substring){

        List<Sensor> result= new ArrayList<>();
        List<Sensor> list =sensorRepository.findAll();
        try{
            for(Sensor sensor: list){
                if(
                sensor.getModel().contains(substring)
                ||sensor.getName().contains(substring)
                ||sensor.getType().contains(substring)
                ||sensor.getUnit().contains(substring)
                ||(sensor.getRangeFrom()+"").contains(substring)
                ||(sensor.getRangeTo()+"").contains(substring)){
                    result.add(sensor);
                    continue;
                } if(sensor.getDescription()!=null){
                    if(sensor.getDescription().contains(substring))
                    {result.add(sensor);continue;}
                }
                if(sensor.getLocation()!=null){
                    if(sensor.getLocation().contains(substring))
                        result.add(sensor);

                }

            }
        }
        finally {
            return result;
        }

    }
    @PostMapping("/sensor/delete")
    public void deleteSensor(@RequestBody int id){
        System.out.println("delete");
        System.out.println(id);
        sensorRepository.delete(id);
    }
    @PostMapping("/sensor/save")
    public void saveSensor(@RequestBody Sensor sensor){
        System.out.println(sensor.getId());
        if(sensor.getId()==0) {
            sensorRepository.save(Sensor.builder()
                    .description(sensor.getDescription())
                    .model(sensor.getModel())
                    .name(sensor.getName())
                    .type(sensor.getType())
                    .unit(sensor.getUnit())
                    .rangeFrom(sensor.getRangeFrom())
                    .rangeTo(sensor.getRangeTo())
                    .location(sensor.getLocation())
                    .build());
        }
        else sensorRepository.save(sensor);
    }


}
