package spring.framework.petclinic.model;

import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
public class Vet extends Person {

    private Set<Speciality> specialties = new HashSet<>();

}
