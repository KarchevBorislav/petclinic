package spring.framework.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Visit extends BaseEntity {

    private LocalDate date;
    private  String description;
    private Pet pet;


}
