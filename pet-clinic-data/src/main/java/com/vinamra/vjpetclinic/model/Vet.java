package com.vinamra.vjpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    //if it's lazy then it does not load anything until it's asked
    @ManyToMany(fetch = FetchType.EAGER)//this means that JPA will try to load everything at once
    @JoinTable(name = "vet_specialities",joinColumns = @JoinColumn(name = "vet_id"),inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
