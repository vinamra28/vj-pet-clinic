package com.vinamra.vjpetclinic.repositories;

import com.vinamra.vjpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
