package spring.framework.petclinic.services;

import org.springframework.data.repository.CrudRepository;
import spring.framework.petclinic.model.Owner;

import java.util.Optional;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
    }
