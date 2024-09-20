package spring.framework.petclinic.services.map;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Pet;
import spring.framework.petclinic.services.PetService;

import java.util.Set;
@Service
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
