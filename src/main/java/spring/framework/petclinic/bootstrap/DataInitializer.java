package spring.framework.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.model.Pet;
import spring.framework.petclinic.model.PetType;
import spring.framework.petclinic.model.Vet;
import spring.framework.petclinic.services.OwnerService;
import spring.framework.petclinic.services.PetService;
import spring.framework.petclinic.services.PetTypeService;
import spring.framework.petclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService  petTypeService;

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setPetTypeName("Dog");
        PetType saveDod = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setPetTypeName("Cat");
        PetType saveCat = petTypeService.save(cat);


        Owner ownerOne = new Owner();

        ownerOne.setFirstName("John");
        ownerOne.setLastName("Snow");
        ownerOne.setAddress("Some Address 1");
        ownerOne.setCity("Some City");
        ownerOne.setTelephoneNumber("+91 123-456-789");
        ownerService.save(ownerOne);

        Pet johnsPet = new Pet();
        johnsPet.setPetType(saveDod);
        johnsPet.setOwner(ownerOne);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setName("Pirin");
        ownerOne.getPets().add(johnsPet);

        Owner ownerTwo = new Owner();

        ownerTwo.setFirstName("Sansa");
        ownerTwo.setLastName("Stark");
        ownerTwo.setAddress("Some Address 2");
        ownerTwo.setCity("Some other City");
        ownerTwo.setTelephoneNumber("+112  123 456-789");

        ownerService.save(ownerTwo);


        Pet sansasPet = new Pet();
        sansasPet.setPetType(saveCat);
        sansasPet.setOwner(ownerOne);
        sansasPet.setBirthDate(LocalDate.now());
        sansasPet.setName("Cat");
        ownerTwo.getPets().add(sansasPet);


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
