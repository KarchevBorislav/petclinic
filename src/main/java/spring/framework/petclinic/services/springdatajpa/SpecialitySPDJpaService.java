package spring.framework.petclinic.services.springdatajpa;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Speciality;
import spring.framework.petclinic.repositories.SpecialtyRepository;
import spring.framework.petclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SpecialitySPDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySPDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Integer id) {




        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialtyRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
    specialtyRepository.delete(speciality);
    }

    @Override
    public void deleteById(Integer id) {

        specialtyRepository.deleteById(id);
    }
}
