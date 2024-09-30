package spring.framework.petclinic.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import spring.framework.petclinic.model.Pet;
import spring.framework.petclinic.model.PetType;
import spring.framework.petclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;


@Component
public class PetTypeFormatter  implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getPetTypeName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getPetTypeName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }











}
