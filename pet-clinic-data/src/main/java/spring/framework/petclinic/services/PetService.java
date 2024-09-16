package spring.framework.petclinic.services;

import org.springframework.data.repository.CrudRepository;
import spring.framework.petclinic.model.Pet;

import java.util.Optional;
import java.util.Set;

public interface PetService extends CrudRepository<Pet, Long> {

    Optional<Pet> findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
