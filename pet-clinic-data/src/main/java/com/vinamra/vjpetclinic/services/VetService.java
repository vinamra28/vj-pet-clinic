package com.vinamra.vjpetclinic.services;

import com.vinamra.vjpetclinic.model.Vet;

import java.util.Set;

public interface VetService
{

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
