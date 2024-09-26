package spring.framework.petclinic.services.map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.model.Pet;
import spring.framework.petclinic.services.OwnerService;
import spring.framework.petclinic.services.PetService;
import spring.framework.petclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Integer> implements OwnerService{

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }



    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {

        if (owner != null) {
                if (owner.getPets() != null) {
                    owner.getPets().forEach(pet -> {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }
                        }else {
                            throw new RuntimeException("Pet type is required");
                        }
                        if (pet.getId() == null){
                            Pet savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());

                        }

                    });
                }
            return super.save(owner);
        }else {
            return  null;
        }



    }

    @Override
    public void delete(Owner owner) {
       super.delete(owner);

    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.map.entrySet().stream().filter(entry -> entry.getValue().getLastName().equals(lastName)).findFirst().get().getValue();
    }
}
