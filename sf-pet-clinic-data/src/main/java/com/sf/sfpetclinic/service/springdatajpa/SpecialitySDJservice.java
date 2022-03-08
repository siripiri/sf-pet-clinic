package com.sf.sfpetclinic.service.springdatajpa;

import com.sf.sfpetclinic.Model.Speciality;
import com.sf.sfpetclinic.repository.SpecialityRespository;
import com.sf.sfpetclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPA")
public class SpecialitySDJservice implements SpecialityService {

    private final SpecialityRespository specialityRespository;

    public SpecialitySDJservice(SpecialityRespository specialityRespository) {
        this.specialityRespository = specialityRespository;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRespository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRespository.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRespository.findAll().forEach(specialities ::add);
        return specialities;
    }

    @Override
    public void delete(Speciality object) {
        specialityRespository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRespository.deleteById(aLong);
    }
}
