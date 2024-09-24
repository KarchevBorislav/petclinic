package spring.framework.petclinic.services.map;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Speciality;
import spring.framework.petclinic.model.Vet;
import spring.framework.petclinic.services.SpecialtyService;
import spring.framework.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Integer> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);

    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);

    }

    @Override
    public Vet findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (!vet.getSpecialties().isEmpty()){
            vet.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null){

                    Speciality savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });

        }


        return super.save(vet);
    }
}
