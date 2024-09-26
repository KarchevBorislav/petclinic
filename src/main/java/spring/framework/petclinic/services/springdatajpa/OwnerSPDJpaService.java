package spring.framework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.repositories.OwnerRepository;
import spring.framework.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;



@Service
@Profile("springdatajpa")
public class OwnerSPDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSPDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;

    }

    @Override
    public Owner findById(Integer id) {

        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);

    }

    @Override
    public void deleteById(Integer id) {
        ownerRepository.deleteById(id);

    }
}
