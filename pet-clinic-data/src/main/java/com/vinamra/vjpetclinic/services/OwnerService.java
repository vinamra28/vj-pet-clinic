package com.vinamra.vjpetclinic.services;

import com.vinamra.vjpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>
{
    Owner findByLastName(String lastName);

}
