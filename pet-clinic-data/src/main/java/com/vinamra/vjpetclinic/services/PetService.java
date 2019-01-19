package com.vinamra.vjpetclinic.services;

import com.vinamra.vjpetclinic.model.Pet;

import java.util.Set;

public interface PetService
{

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
