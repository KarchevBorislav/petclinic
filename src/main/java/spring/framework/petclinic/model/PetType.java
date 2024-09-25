package spring.framework.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "types")
public class PetType  extends BaseEntity {

    @Column(name = "pet_type_name")
    private String  petTypeName;

}
