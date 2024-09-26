package spring.framework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.framework.petclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality,Integer> {
}
