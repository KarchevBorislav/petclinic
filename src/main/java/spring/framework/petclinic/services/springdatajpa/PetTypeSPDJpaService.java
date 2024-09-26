package spring.framework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.PetType;
import spring.framework.petclinic.repositories.PetTypeRepository;
import spring.framework.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")

public class PetTypeSPDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSPDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<PetType>();
        petTypeRepository.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public PetType findById(Integer id) {

        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);

    }

    @Override
    public void deleteById(Integer id) {
        petTypeRepository.deleteById(id);

    }
}
