package maksim.moiseenko.controllers;

import maksim.moiseenko.dto.SensorDto;
import maksim.moiseenko.models.Sensor;
import maksim.moiseenko.models.Type;
import maksim.moiseenko.models.Unit;
import maksim.moiseenko.repositories.SensorRepository;
import maksim.moiseenko.repositories.TypeRepository;
import maksim.moiseenko.repositories.UnitRepository;
import maksim.moiseenko.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class SensorController {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private SensorService sensorService;

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
        return sensorService.getAllSensors();
    }

    @GetMapping("/sensor/{id}")
    public Sensor getSensor(@PathVariable int id){
        return sensorService.findOneById(id);
    }

    @GetMapping("/sensors/search/{substring}")
    public List<Sensor> getSensorsSearch(@PathVariable String substring){
        return sensorService.search(substring);
    }

    @PostMapping("/sensor/delete")
    public void deleteSensor(@RequestBody int id){
        System.out.println("delete sensor with id: "+id);
        sensorService.deleteById(id);
    }

    @PostMapping("/sensor/save")
    public void saveSensor(@RequestBody Sensor sensor){
        sensorService.save(sensor);
    }


}
