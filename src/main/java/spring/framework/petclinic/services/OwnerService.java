package spring.framework.petclinic.services;

import spring.framework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Integer> {
    Owner findByLastName(String lastName);
    }
