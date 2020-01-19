package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.RecipeIngredientsRepo;
import se.jpdc.receptdemo.model.*;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    @Autowired
    RecipeIngredientsRepo repo;

    @Autowired
    RecipeEntityService recipeEntityService;

    @Autowired
    IngredientEntityService ingredientEntityService;


    @Override
    public RecipeIngredientDTO addIngredientToRecipe(RecipeIngredientWrapper recipeIngredientWapper) {
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        Recipe recipe = recipeEntityService.getRecipyEntity(recipeIngredientWapper.getRecipeId());
        Ingredient ingredient = ingredientEntityService.getIngredientEntity(recipeIngredientWapper.getIngredientId());
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setAmount(recipeIngredientWapper.getAmount());
        RecipeIngredient storedRecipeIngredient = repo.save(recipeIngredient);
        return convertToDTO(storedRecipeIngredient);
    }


    private RecipeIngredientDTO convertToDTO (RecipeIngredient recipeIngredient) {
        RecipeIngredientDTO dto = new RecipeIngredientDTO();
        dto.setId(recipeIngredient.getId());
        dto.setAmount(recipeIngredient.getAmount());
        dto.setIngredientId(recipeIngredient.getIngredient().getId());
        dto.setRecipeId(recipeIngredient.getRecipe().getId());
        return dto;
    }



}
