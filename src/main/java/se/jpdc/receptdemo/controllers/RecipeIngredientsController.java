package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.jpdc.receptdemo.model.CompleteRecipeDTO;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredientWrapper;
import se.jpdc.receptdemo.service.RecipeIngredientService;

import java.util.List;

@RestController
@RequestMapping("/recipe-ingredient")
public class RecipeIngredientsController {

    @Autowired
    RecipeIngredientService recipeIngredientService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeIngredientDTO addRecipeIngredientToRecipe(@RequestBody RecipeIngredientWrapper recipeIngredient) {
        return recipeIngredientService.addIngredientToRecipe(recipeIngredient);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRecipeIngredient(@PathVariable Long id) {
        recipeIngredientService.deleteRecipeIngredient(id);
    }

    @GetMapping("/get/id/{id}")
    public List<RecipeIngredientDTO> getIngredientsToRecipe(@PathVariable Long id) {
        return recipeIngredientService.getIngredientsForRecipe(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RecipeIngredientDTO updateRecipeIngredient(@RequestBody RecipeIngredientDTO recipeIngredientDTO) {
        return recipeIngredientService.updateRecipeIngredient(recipeIngredientDTO);
    }

    @GetMapping("/get/complete/id/{id}")
    public CompleteRecipeDTO getCompleteRecipe(@PathVariable Long id) {
        return recipeIngredientService.getCompleteRecipe(id);
    }

}
