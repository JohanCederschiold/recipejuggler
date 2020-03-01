package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.RecipeDTO;
import se.jpdc.receptdemo.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRecepy(@PathVariable Long id ) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RecipeDTO updateRecipy(@RequestBody Recipe recipe){
        return recipeService.updateRecipe(recipe);
    }

    @GetMapping("/find/name/{name}")
    public List<RecipeDTO> findRecipesByName(@PathVariable String name) {
        return recipeService.findRecipeByName(name);
    }

    @GetMapping("/find/owner/{name}")
    public List<RecipeDTO> findRecipesByOwner(@PathVariable String name) {
        return recipeService.findRecipiesByOwner(name);
    }

    @GetMapping("/all")
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/find/id/{id}")
    public RecipeDTO findRecipeById(@PathVariable Long id) {
        return recipeService.findRecipyById(id);
    }

    @GetMapping("/find/searchstring/{searchString}")
    public List<RecipeDTO> findRecipesByNameContaining (@PathVariable String searchString) {
        return recipeService.searchRecipesByTitleContaining(searchString);
    }

    @GetMapping("find/ingredient/{ingredient}")
    public List<RecipeDTO> findRecipeByIngredient(@PathVariable String ingredient) {
        return recipeService.searchRecipesByIngredients(ingredient);
    }
}
