package com.sf.sfpetclinic.service;

import com.sf.sfpetclinic.Model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner findByLastname(String lastname);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
