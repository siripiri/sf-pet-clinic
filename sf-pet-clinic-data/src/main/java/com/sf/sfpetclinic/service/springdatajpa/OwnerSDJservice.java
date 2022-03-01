package com.sf.sfpetclinic.service.springdatajpa;

import com.sf.sfpetclinic.Model.Owner;
import com.sf.sfpetclinic.repository.OwnerRepository;
import com.sf.sfpetclinic.repository.PetRepository;
import com.sf.sfpetclinic.repository.PetTypeRepository;
import com.sf.sfpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJPA")
public class OwnerSDJservice implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public OwnerSDJservice(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
                           PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastname(String lastname) {
        return ownerRepository.findByLastname(lastname);
    }
}
