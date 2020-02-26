package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.*;

import java.util.List;

public interface RecipeIngredientService {

    public RecipeIngredientDTO addIngredientToRecipe(RecipeIngredientWrapper recipeIngredient);
    public List<RecipeIngredientDTO> getIngredientsForRecipe(Long id);
    public void deleteRecipeIngredient(Long id);
    public RecipeIngredientDTO updateRecipeIngredient(RecipeIngredientDTO recipeIngredientDTO);
    public CompleteRecipeDTO getCompleteRecipe(Long id);
    public List<RecipeIngredientNameDTO> getIngredientsForRecipeIds(List<Long> ids);

}
