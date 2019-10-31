package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.IngredientsRepo;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredient;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientsRepo repo;

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
