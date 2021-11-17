package com.sf.sfpetclinic.service;

import com.sf.sfpetclinic.Model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
