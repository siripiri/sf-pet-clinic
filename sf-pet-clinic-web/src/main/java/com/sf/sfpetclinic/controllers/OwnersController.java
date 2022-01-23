package com.sf.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnersController {
    @RequestMapping("/owners")
    public String listOwners() {
        return "owner/index";
    }
}
