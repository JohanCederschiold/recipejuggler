package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.Ingredients;
import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.RecipeDTO;

public interface RecipeService {

    public void addRecipe(RecipeDTO recipe);
    public void addIngredientToRecipe(long recipeId, Ingredients ingredients);

}
