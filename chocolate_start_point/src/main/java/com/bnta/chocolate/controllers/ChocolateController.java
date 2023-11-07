package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(
            @RequestParam(required = false, name = "cocoaPercentage") Integer cocoaPercentage
    ){
        if(cocoaPercentage!=null){
            return new ResponseEntity<>(chocolateService.getAllChocolatesAbove60Percent(cocoaPercentage),HttpStatus.OK);
        }

        return new ResponseEntity<>(chocolateService.getAllChocolates(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Optional<Chocolate> optionalChocolate = chocolateService.getChocolateById(id);
        return new ResponseEntity<>(optionalChocolate.isEmpty()?null:optionalChocolate.get(), optionalChocolate.isEmpty()?HttpStatus.NOT_FOUND: HttpStatus.OK);
    }

}