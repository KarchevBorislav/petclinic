package spring.framework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.framework.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Integer ownerId = 1;
    final String ownerLastName = "LastName";


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapServiceImpl(), new PetMapService());

        ownerMapService.save(Owner.builder().id(1).lastName(ownerLastName ).build());

    }


    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
        Owner byId = ownerMapService.findById(ownerId);
        assertEquals(ownerId,byId.getId());
    }

    @Test
    void saveExistingId() {
        int id = 2;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId () {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
      assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void findByLastName() {

        Owner byLastName = ownerMapService.findByLastName(ownerLastName);

        assertNotNull(byLastName);
        assertEquals(byLastName,ownerMapService.findByLastName(ownerLastName));

    }

    @Test
    void findByLastNameNotFound() {
        Owner byLastName = ownerMapService.findByLastName("notFound");
        assertNull(byLastName);
    }
}