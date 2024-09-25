package spring.framework.petclinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private  String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;


}
