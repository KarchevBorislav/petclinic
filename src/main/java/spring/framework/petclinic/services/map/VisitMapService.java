package spring.framework.petclinic.services.map;

import spring.framework.petclinic.model.Visit;
import spring.framework.petclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Integer> implements VisitService {
    @Override
    public Set<Visit> findAll() {


        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);

    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);

    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId()== null)  {
throw new RuntimeException("Invalid visit")

        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Integer id) {
        return super.findById(id);
    }
}
