package com.sf.sfpetclinic.controllers;

import com.sf.sfpetclinic.Model.Owner;
import com.sf.sfpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping("/owners")
    public String listOwners(Model model) {
        model.addAttribute("owners",ownerService.findAll());
        return "owner/index";
    }
}
