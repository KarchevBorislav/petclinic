package spring.framework.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

}
