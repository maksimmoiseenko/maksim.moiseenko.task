package maksim.moiseenko.services;

import maksim.moiseenko.models.Type;
import maksim.moiseenko.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeService {
    final private TypeRepository typeRepository;
    @Autowired
    public TypeService(TypeRepository typeRepository){
        this.typeRepository=typeRepository;
    }
    public List<Type> getTypes(){
        return typeRepository.findAll();
    }
}
