package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredientWrapper;
import se.jpdc.receptdemo.service.RecipeIngredientService;

@RestController
@RequestMapping("/recipe-ingredient")
public class RecipeIngredientsController {

    @Autowired
    RecipeIngredientService recipeIngredientService;

    @PostMapping("/add")
    public RecipeIngredientDTO addRecipeIngredientToRecipe(@RequestBody RecipeIngredientWrapper recipeIngredient) {
        return recipeIngredientService.addIngredientToRecipe(recipeIngredient);
    }


}
