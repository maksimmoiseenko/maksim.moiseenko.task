package maksim.moiseenko.controllers;

import maksim.moiseenko.dto.SensorDto;
import maksim.moiseenko.models.Sensor;
import maksim.moiseenko.models.Type;
import maksim.moiseenko.models.Unit;
import maksim.moiseenko.repositories.SensorRepository;
import maksim.moiseenko.repositories.TypeRepository;
import maksim.moiseenko.repositories.UnitRepository;
import maksim.moiseenko.services.SensorService;
import maksim.moiseenko.services.TypeService;
import maksim.moiseenko.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class SensorController {


    private final TypeService typeService;

    private final UnitService unitService;

    private final SensorService sensorService;

    @Autowired
    public SensorController(TypeService typeService,
                            UnitService unitService,
                            SensorService sensorService){
        this.typeService=typeService;
        this.unitService=unitService;
        this.sensorService=sensorService;
    }
    @GetMapping("/types")
    public List<Type> getTypes(){
        return typeService.getTypes();
    }

    @GetMapping("/units")
    public List<Unit> getUnits(){
        return unitService.getUnits();
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

    @DeleteMapping("/sensor/delete")
    public void deleteSensor(@RequestBody int id){
        System.out.println("delete sensor with id: "+id);
        sensorService.deleteById(id);
    }

    @PostMapping("/sensor/save")
    public void saveSensor(@RequestBody Sensor sensor){
        sensorService.save(sensor);
    }


}
