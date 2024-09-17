package spring.framework.petclinic.services.map;

import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.services.CrudService;
import spring.framework.petclinic.services.OwnerService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner,Long> {

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
        return super.save(owner.getId(),owner);
    }

    @Override
    public void delete(Owner owner) {
       super.delete(owner);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
