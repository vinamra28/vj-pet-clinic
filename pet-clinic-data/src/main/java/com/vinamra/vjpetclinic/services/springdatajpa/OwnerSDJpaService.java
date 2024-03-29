package com.vinamra.vjpetclinic.services.springdatajpa;

import com.vinamra.vjpetclinic.model.Owner;
import com.vinamra.vjpetclinic.repositories.OwnerRepository;
import com.vinamra.vjpetclinic.repositories.PetRepository;
import com.vinamra.vjpetclinic.repositories.PetTypeRepository;
import com.vinamra.vjpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
//        if(optionalOwner.isPresent()){
//            return optionalOwner.get();
//        }else{
//            return null;
//        }
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    public void sayHello() {
        System.out.println("Hello world");
    }
}
