package spring.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.petclinic.model.Owner;


import java.util.Optional;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    Owner findByLastName(String lastName);

}
