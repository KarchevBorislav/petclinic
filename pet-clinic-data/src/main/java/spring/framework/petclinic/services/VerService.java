package spring.framework.petclinic.services;

import org.springframework.data.repository.CrudRepository;
import spring.framework.petclinic.model.Vet;

import java.util.Optional;
import java.util.Set;

public interface VerService extends CrudService<Vet, Long> {

}
