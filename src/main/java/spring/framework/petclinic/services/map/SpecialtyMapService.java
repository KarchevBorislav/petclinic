package spring.framework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Speciality;
import spring.framework.petclinic.services.SpecialtyService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialtyMapService extends AbstractMapService<Speciality,Integer> implements SpecialtyService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete( Speciality speciality ) {
        super.delete(speciality);

    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);

    }

    @Override
    public Speciality save(Speciality speciality) {



        return super.save(speciality);
    }

    @Override
    public Speciality findById(Integer id) {
        return super.findById(id);
    }
}
