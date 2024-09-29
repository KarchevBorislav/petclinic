package spring.framework.petclinic.services;

import spring.framework.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Integer> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

    }
