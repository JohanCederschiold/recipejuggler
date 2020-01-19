package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.RecipeDTO;

import java.util.List;

public interface RecipeService {

    public RecipeDTO addRecipe(Recipe recipe);
    public void deleteRecipe(Long id);
    public RecipeDTO updateRecipe(Recipe recipe);
    public RecipeDTO findRecipyById(Long id);
    public List<RecipeDTO> findRecipeByName(String name);
    public List<RecipeDTO> findRecipiesByOwner(String ownerName);


}
