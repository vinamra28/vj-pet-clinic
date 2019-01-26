package com.vinamra.vjpetclinic.bootstrap;

import com.vinamra.vjpetclinic.model.*;
import com.vinamra.vjpetclinic.services.OwnerService;
import com.vinamra.vjpetclinic.services.PetTypeService;
import com.vinamra.vjpetclinic.services.SpecialtyService;
import com.vinamra.vjpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner
{

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    //@Autowired not required after spring version 4.2
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception
    {

        int count = petTypeService.findAll().size();
        if(count ==0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        //we need not to set the id over here bcz in our AbstractMapService class we have generated the id value automatically
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("195 Police Street");
        owner1.setCity("Meerut");
        owner1.setTelephone("89898989898");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glen");
        owner2.setAddress("195 Police Street");
        owner2.setCity("Delhi");
        owner2.setTelephone("1234567890");

        Pet fioansCat = new Pet();
        fioansCat.setPetType(savedCatPetType);
        fioansCat.setOwner(owner2);
        fioansCat.setBirthDate(LocalDate.now());
        fioansCat.setName("Cynthia");
        owner2.getPets().add(fioansCat);

        ownerService.save(owner2);

        System.out.println("Loading owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loading vets....");
    }
}
