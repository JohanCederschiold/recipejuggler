package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.service.IngredientService;

@RestController
public class IngredientsController {

    @Autowired
    IngredientService service;

    @PostMapping("/addingredient")
    public void addRecipe(@RequestBody RecipeIngredient ingredient) {
        service.addIngredient(ingredient);
    }

}
