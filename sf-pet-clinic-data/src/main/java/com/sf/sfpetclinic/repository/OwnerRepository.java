package com.sf.sfpetclinic.repository;

import com.sf.sfpetclinic.Model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastname(String lastname);
}
