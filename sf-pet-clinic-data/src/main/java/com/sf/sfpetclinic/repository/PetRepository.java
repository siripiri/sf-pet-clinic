package com.sf.sfpetclinic.repository;

import com.sf.sfpetclinic.Model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
