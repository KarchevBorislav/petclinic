package spring.framework.petclinic.services.springdatajpa;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Pet;
import spring.framework.petclinic.repositories.PetRepository;
import spring.framework.petclinic.services.PetService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PetSPDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSPDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet findById(Integer id) {


        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);

    }

    @Override
    public void deleteById(Integer id) {
        petRepository.deleteById(id);

    }
}
