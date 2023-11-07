package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        return new ResponseEntity<>(estateService.getAllEstates(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable long id){
        Optional<Estate> optionalEstate = estateService.getEstateById(id);
        return new ResponseEntity<>(optionalEstate.isEmpty()?null:optionalEstate.get(), optionalEstate.isEmpty()?HttpStatus.NOT_FOUND: HttpStatus.OK);
    }
}
