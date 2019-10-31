package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.RecipeDTO;

public interface RecipeService {

    public void addRecipe(RecipeDTO recipe);
    public void addIngredientToRecipe(long recipeId, RecipeIngredient recipeIngredient);

}
