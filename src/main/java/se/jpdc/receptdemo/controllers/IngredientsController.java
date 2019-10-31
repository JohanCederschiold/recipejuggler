package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.jpdc.receptdemo.database.IngredientsRepo;
import se.jpdc.receptdemo.database.RecipeRepository;
import se.jpdc.receptdemo.model.Ingredients;
import se.jpdc.receptdemo.model.RecipeDTO;

@RestController
public class IngredientsController {

    @Autowired
    IngredientsRepo repo;

    @PostMapping("/addingredient")
    public void addRecipe(@RequestBody Ingredients ingredients) {
        repo.save(ingredients);
    }

}
