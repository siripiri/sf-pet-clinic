package com.sf.sfpetclinic.service.springdatajpa;

import com.sf.sfpetclinic.Model.Owner;
import com.sf.sfpetclinic.repository.OwnerRepository;
import com.sf.sfpetclinic.repository.PetRepository;
import com.sf.sfpetclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJserviceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJservice ownerSDJservice;

    Long ownerId = 1L;
    String ownerLastname = "Smith";
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(ownerId);
        returnOwner.setLastname(ownerLastname);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJservice.findById(ownerId);
        assertNotNull(owner);
        assertEquals(returnOwner, owner);
    }

    @Test
    void save() {
        Owner newOwner = new Owner();
        newOwner.setId(2L);
        when(ownerRepository.save(any())).thenReturn(newOwner);
        Owner savedOwner = ownerSDJservice.save(newOwner);
        assertNotNull(savedOwner);
        assertEquals(newOwner, savedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnOwner);
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> returnedSet = ownerSDJservice.findAll();
        assertEquals(returnedSet.size(), ownerSet.size());
    }

    @Test
    void delete() {
        ownerSDJservice.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
        assertEquals(ownerSDJservice.findAll().size(), 0);
    }

    @Test
    void deleteById() {
        ownerSDJservice.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(any());
        assertEquals(ownerSDJservice.findAll().size(),0);
    }

    @Test
    void findByLastname() {
        when(ownerRepository.findByLastname(any())).thenReturn(returnOwner);
        Owner resultOwner = ownerSDJservice.findByLastname(ownerLastname);
        assertEquals(resultOwner.getLastname(), ownerLastname);
        assertEquals(resultOwner, returnOwner);
        verify(ownerRepository).findByLastname(any());
    }
}