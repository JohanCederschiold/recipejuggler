package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.RecipeIngredientsRepo;
import se.jpdc.receptdemo.model.*;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteRecipeIngredient(Long id) {
        RecipeIngredient recipeIngredientToDelete = repo.getOne(id);
        repo.delete(recipeIngredientToDelete);
    }

    public RecipeIngredientDTO updateRecipeIngredient(RecipeIngredientDTO recipeIngredientDTO) {
        RecipeIngredient originalRecipeIngredient = repo.getOne(recipeIngredientDTO.getId());

        //Check if recipeid is different from before. If so search for recipe and add to recipeIngredient
        if(originalRecipeIngredient.getRecipe().getId() != recipeIngredientDTO.getRecipeId()) {
            Recipe recipe = recipeEntityService.getRecipyEntity(recipeIngredientDTO.getRecipeId());
            originalRecipeIngredient.setRecipe(recipe);
        }

        if(originalRecipeIngredient.getIngredient().getId() != recipeIngredientDTO.getIngredientId()) {
            Ingredient ingredient = ingredientEntityService.getIngredientEntity(recipeIngredientDTO.getIngredientId());
            originalRecipeIngredient.setIngredient(ingredient);
        }

        if(originalRecipeIngredient.getAmount() != recipeIngredientDTO.getAmount()) {
            originalRecipeIngredient.setAmount(recipeIngredientDTO.getAmount());
        }

        RecipeIngredient updatedRecipeIngredient = repo.save(originalRecipeIngredient);
        return convertToDTO(updatedRecipeIngredient);

    }

    public List<RecipeIngredientDTO> getIngredientsForRecipe(Long id) {
        List<RecipeIngredientDTO> dtos = new ArrayList<>();
        List<RecipeIngredient> results = repo.findRecipeIngredientsByRecipe_Id(id);
        for (RecipeIngredient ri : results) {
            dtos.add(convertToDTO(ri));
        }
        return dtos;
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
