package spring.framework.petclinic.services.springdatajpa;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Visit;
import spring.framework.petclinic.repositories.VisitRepository;
import spring.framework.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class VisitSPDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSPDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Integer id) {


        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);

    }

    @Override
    public void deleteById(Integer id) {
        visitRepository.deleteById(id);

    }
}
