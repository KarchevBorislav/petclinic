package spring.framework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.framework.petclinic.model.Pet;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService petMapService;
    final int id = 1;
    final String name = "Pet";

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(name);

        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(pets.size(), 1);

    }

    @Test
    void delete() {
        petMapService.deleteById(id);
        assertPetSize();

    }

    @Test
    void deleteById() {
        petMapService.deleteById(id);
        assertPetSize();
    }

    private void assertPetSize() {
        assertEquals(0, petMapService.findAll().size());
    }

    @Test
    void findById() {
        Pet byId = petMapService.findById(id);
        assertEquals(id, byId.getId());

    }

    @Test
    void saveExistingId() {
        int id = 2;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petMapService.save(pet2);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveNoId() {

        Pet savePet = petMapService.save(Pet.builder().build());

        assertNotNull(savePet);
        assertNotNull(savePet.getId());

    }
}