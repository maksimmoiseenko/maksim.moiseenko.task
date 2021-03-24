package maksim.moiseenko.services;

import maksim.moiseenko.models.Unit;
import maksim.moiseenko.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    final private UnitRepository unitRepository;
    @Autowired
    public UnitService(UnitRepository unitRepository){
        this.unitRepository=unitRepository;
    }
    public List<Unit> getUnits(){
        return unitRepository.findAll();
    }
}
