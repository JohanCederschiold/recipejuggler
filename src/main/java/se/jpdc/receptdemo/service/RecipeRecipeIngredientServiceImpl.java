package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.RecipeIngredientsRepo;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredient;

@Service
public class RecipeRecipeIngredientServiceImpl implements RecipeIngredientService {

    @Autowired
    RecipeIngredientsRepo repo;

    @Override
    public void addIngredient(RecipeIngredient ingredient) {
        repo.save(ingredient);
    }


    private RecipeIngredient convertFromDTO (RecipeIngredientDTO recipeIngredientDTO) {
        RecipeIngredient ingredient = new RecipeIngredient();
        ingredient.setName(recipeIngredientDTO.getName());
        return ingredient;
    }

}
