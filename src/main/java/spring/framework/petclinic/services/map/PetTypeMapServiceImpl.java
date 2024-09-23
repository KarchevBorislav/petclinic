package spring.framework.petclinic.services.map;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.PetType;
import spring.framework.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class PetTypeMapServiceImpl extends AbstractMapService<PetType,Integer>  implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);

    }

    @Override
    public void deleteById(Integer id) {
    super.deleteById(id);
    }
}
