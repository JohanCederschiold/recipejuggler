package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.jpdc.receptdemo.database.RecipeRepository;
import se.jpdc.receptdemo.model.Ingredients;
import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.RecipeDTO;
import se.jpdc.receptdemo.service.IngredientService;
import se.jpdc.receptdemo.service.RecipeService;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @PostMapping("/addrecipe")
    public void addRecipe(@RequestBody RecipeDTO recipe) {
        recipeService.addRecipe(recipe);
    }

    @PostMapping("/addtorecepy/{id}")
    public void addToRecipy(@RequestBody Ingredients ingredient, @PathVariable Long id) {
        recipeService.addIngredientToRecipe(id, ingredient );
    }

}
