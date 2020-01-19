package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredientWrapper;

public interface RecipeIngredientService {

    public RecipeIngredientDTO addIngredientToRecipe(RecipeIngredientWrapper recipeIngredient);

}
