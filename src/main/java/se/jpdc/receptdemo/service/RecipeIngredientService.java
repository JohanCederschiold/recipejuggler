package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredientWrapper;

import java.util.List;

public interface RecipeIngredientService {

    public RecipeIngredientDTO addIngredientToRecipe(RecipeIngredientWrapper recipeIngredient);
    public List<RecipeIngredientDTO> getIngredientsForRecipe(Long id);
    public void deleteRecipeIngredient(Long id);
    public RecipeIngredientDTO updateRecipeIngredient(RecipeIngredientDTO recipeIngredientDTO);

}
