package spring.framework.petclinic.services;

import org.springframework.data.repository.CrudRepository;
import spring.framework.petclinic.model.Pet;

import java.util.Optional;
import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {

}
