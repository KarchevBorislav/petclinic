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
@Builder
@Table(name = "speciality")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

}
