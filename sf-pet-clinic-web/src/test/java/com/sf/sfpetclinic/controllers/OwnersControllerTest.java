package com.sf.sfpetclinic.controllers;

import com.sf.sfpetclinic.Model.Owner;
import com.sf.sfpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @InjectMocks
    OwnersController ownersController;

    @Mock
    Model model;

    @Mock
    OwnerService ownerService;

    Set<Owner> ownerMockSet;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        ownerMockSet = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        ownerMockSet.add(owner1);
        ownerMockSet.add(owner2);

        mockMvc = MockMvcBuilders
                  .standaloneSetup(ownersController)
                  .build();
    }

    // List owners test by mockmvc
    @Test
    void listOwnersMockMVC() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerMockSet);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }


    // Implement using mockito and argument captor
    @Test
    void listOwnersMockito() {
        ownersController = new OwnersController(ownerService);

        when(ownerService.findAll()).thenReturn(ownerMockSet);
        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String name = ownersController.listOwners(model);

        assertEquals(name,"owner/index");
        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), argumentCaptor.capture());
        Set<Owner> resultOwnerMockSet = argumentCaptor.getValue();
        assertEquals(resultOwnerMockSet.size(), ownerMockSet.size());
    }
}