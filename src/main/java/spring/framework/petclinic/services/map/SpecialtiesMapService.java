package spring.framework.petclinic.services.map;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Speciality;
import spring.framework.petclinic.services.SpecialtiesService;

import java.util.Set;

@Service
public class SpecialtiesMapService extends AbstractMapService<Speciality,Integer> implements SpecialtiesService {

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
