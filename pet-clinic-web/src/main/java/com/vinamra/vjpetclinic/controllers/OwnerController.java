package com.vinamra.vjpetclinic.controllers;

import com.vinamra.vjpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//prefixing the route at the class level to avoid writing similar again and again
@RequestMapping("/owners")
@Controller
public class OwnerController
{

    //declared final over here so that object cannot be changed
    private final OwnerService ownerService;

    //constructor injection applied over here
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(Model model)
    {
        //called by spring MVC
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners()
    {
        return "notimplemented";
    }

}
