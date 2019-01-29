package com.vinamra.vjpetclinic.services.map;

import com.vinamra.vjpetclinic.model.Speciality;
import com.vinamra.vjpetclinic.model.Vet;
import com.vinamra.vjpetclinic.services.SpecialtyService;
import com.vinamra.vjpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService
{
    private final SpecialtyService specialtyService;
    private final SpecialityMapService specialityMapService;

    public VetMapService(SpecialtyService specialtyService, SpecialityMapService specialityMapService) {
        this.specialtyService = specialtyService;
        this.specialityMapService = specialityMapService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object)
    {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }
}
