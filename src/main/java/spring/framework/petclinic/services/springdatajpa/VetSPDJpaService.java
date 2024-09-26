package spring.framework.petclinic.services.springdatajpa;

import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Vet;
import spring.framework.petclinic.repositories.VetRepository;
import spring.framework.petclinic.services.VetService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VetSPDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSPDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Integer id) {


        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);

    }

    @Override
    public void deleteById(Integer id) {

        vetRepository.deleteById(id);

    }
}
