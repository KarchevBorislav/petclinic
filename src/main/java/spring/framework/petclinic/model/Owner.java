package spring.framework.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor


@Table(name = "owners")
public class Owner extends Person {
    @Builder
    public Owner(Integer id, String firstName, String lastName, String address, String city,
                 String telephoneNumber, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephoneNumber = telephoneNumber;

        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();


    public Pet getPet(String name) {
        return getPet(name, false);

    }


    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();

        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;

                }
            }

        }

        return null;
    }
}
