package spring.framework.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "types")
public class PetType  extends BaseEntity {

    @Column(name = "pet_type_name")
    private String  petTypeName;

    @Override
    public String toString() {
        return petTypeName;
    }
    @Builder
    public PetType(Integer id, String petTypeName) {
        super(id);
        this.petTypeName = petTypeName;
    }
}
