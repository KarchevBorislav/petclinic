package spring.framework.petclinic.model;

public class PetType  extends BaseEntity {

    private String  petTypeName;

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }
}
