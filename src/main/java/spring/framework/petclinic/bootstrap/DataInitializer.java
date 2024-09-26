package spring.framework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.framework.petclinic.model.*;
import spring.framework.petclinic.services.*;

import java.time.LocalDate;


@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();


        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setPetTypeName("Dog");
        PetType saveDod = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setPetTypeName("Cat");
        PetType saveCat = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);


        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);


        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


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


        Pet sansasPet = new Pet();
        sansasPet.setPetType(saveCat);
        sansasPet.setOwner(ownerOne);
        sansasPet.setBirthDate(LocalDate.now());
        sansasPet.setName("Cat");
        ownerTwo.getPets().add(sansasPet);

        ownerService.save(ownerTwo);

        Visit catVisit = new Visit();
        catVisit.setPet(sansasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Just a cat");
        visitService.save(catVisit);



        System.out.println("Loaded Owners...");

        Vet vetOne = new Vet();

        vetOne.setFirstName("John");
        vetOne.setLastName("Doe");
        vetOne.getSpecialties().add(savedDentistry);
        vetService.save(vetOne);

        Vet vetTwo = new Vet();

        vetTwo.setFirstName("Eugen");
        vetTwo.setLastName("Brown");
        vetService.save(vetTwo);
        vetTwo.getSpecialties().add(savedSurgery);
        System.out.println("Loaded Vets...");


    }
}
