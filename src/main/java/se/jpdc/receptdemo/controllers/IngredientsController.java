package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.jpdc.receptdemo.model.Ingredient;
import se.jpdc.receptdemo.model.IngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.service.IngredientService;
import se.jpdc.receptdemo.service.RecipeIngredientService;

@RestController
public class IngredientsController {

    @Autowired
    IngredientService service;

    @PostMapping("/addingredient")
    public IngredientDTO addRecipe(@RequestBody Ingredient ingredient) {
        return service.addNewIngredient(ingredient);
    }

}
