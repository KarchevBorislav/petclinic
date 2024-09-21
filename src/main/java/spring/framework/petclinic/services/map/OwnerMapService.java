package spring.framework.petclinic.services.map;


import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.services.OwnerService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public void delete(Owner owner) {
       super.delete(owner);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.map.entrySet().stream().filter(entry -> entry.getValue().getLastName().equals(lastName)).findFirst().get().getValue();
    }
}
