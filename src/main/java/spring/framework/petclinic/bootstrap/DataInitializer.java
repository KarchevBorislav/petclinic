package spring.framework.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.model.Vet;
import spring.framework.petclinic.services.OwnerService;
import spring.framework.petclinic.services.VetService;


@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner ownerOne = new Owner();

        ownerOne.setFirstName("John");
        ownerOne.setLastName("Snow");

        ownerService.save(ownerOne);

        Owner ownerTwo = new Owner();

        ownerTwo.setFirstName("Sansa");
        ownerTwo.setLastName("Stark");

        ownerService.save(ownerTwo);


        System.out.println("Loaded Owners...");

        Vet vetOne = new Vet();

        vetOne.setFirstName("John");
        vetOne.setLastName("Doe");

        vetService.save(vetOne);

        Vet vetTwo = new Vet();

        vetTwo.setFirstName("Eugen");
        vetTwo.setLastName("Brown");
        vetService.save(vetTwo);
        System.out.println("Loaded Vets...");

    }
}
