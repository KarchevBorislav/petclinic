package spring.framework.petclinic.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import spring.framework.petclinic.model.Owner;
import spring.framework.petclinic.model.Pet;
import spring.framework.petclinic.model.PetType;
import spring.framework.petclinic.services.OwnerService;
import spring.framework.petclinic.services.PetService;
import spring.framework.petclinic.services.PetTypeService;

import java.util.Collection;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {

    private static final String VIEWS_PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";



    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }


    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Integer ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {

        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEWS_PET_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Integer petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model, @PathVariable String petId) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE_FORM;
        } else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }



}