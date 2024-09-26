package spring.framework.petclinic.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialties = new HashSet<>();

}
