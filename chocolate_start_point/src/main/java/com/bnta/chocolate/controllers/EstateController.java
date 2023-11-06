package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping
    public List<Estate> getAllEstates(){
        return estateService.getAllEstates();
    }
}
