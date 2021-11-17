package com.sf.sfpetclinic.service;

import com.sf.sfpetclinic.Model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
