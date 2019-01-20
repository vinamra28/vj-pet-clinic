package com.vinamra.vjpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//prefixing the route at the class level to avoid writing similar again and again
@RequestMapping("/owners")
@Controller
public class OwnerController
{
    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners()
    {
        return "owners/index";
    }
}
