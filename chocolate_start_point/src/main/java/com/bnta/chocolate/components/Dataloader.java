package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner{

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    public void run(ApplicationArguments args){
        Estate estate1 = new Estate("Capybara_house","Mexico");
        Estate estate2 = new Estate("Cacao_land","Cuba");

        estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);

        Chocolate chocolate1 = new Chocolate("mars", 50,estate1);
        Chocolate chocolate2 = new Chocolate("bounty", 40,estate1);
        Chocolate chocolate3 = new Chocolate("bueno", 30,estate2);
        Chocolate chocolate4 = new Chocolate("milkybar", 20,estate2);

        chocolateService.saveChocolate(chocolate1);
        chocolateService.saveChocolate(chocolate2);
        chocolateService.saveChocolate(chocolate3);
        chocolateService.saveChocolate(chocolate4);

    }
}
