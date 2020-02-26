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
    RecipeService recipeService;

    @Autowired
    IngredientEntityService ingredientEntityService;

    @Autowired
    StepService stepService;


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

    @Override
    public CompleteRecipeDTO getCompleteRecipe(Long id) {

        System.out.println(id);

        RecipeDTO recipe = recipeService.findRecipyById(id);
        System.out.println(recipe != null);
        List<RecipeIngredientDTO> ingredients = getIngredientsForRecipe(id);
        System.out.println(ingredients.size());
        List<IngredientAmountDTO> ingredientAmounts = new ArrayList<>();

        for(RecipeIngredientDTO dto : ingredients) {
            Ingredient ingredientNameAndUnit = ingredientEntityService.getIngredientEntity(dto.getIngredientId());

            IngredientAmountDTO ingredientAmountDTO = new IngredientAmountDTO(  ingredientNameAndUnit.getName(),
                                                                                ingredientNameAndUnit.getUnit(),
                                                                                dto.getAmount());
            ingredientAmounts.add(ingredientAmountDTO);
        }

        List<StepDTO> steps = stepService.getStepsToRecipeByRecipeId(id);


        return new CompleteRecipeDTO(id, recipe.getTitle(),recipe.getOwner(), recipe.getPreparationTimeMinutes(),
                    recipe.getNoPortions(), recipe.getInstructions(), ingredientAmounts, steps);
    }

    @Override
    public List<RecipeIngredientNameDTO> getIngredientsForRecipeIds(List<Long> ids) {
        List<RecipeIngredientNameDTO> dto = new ArrayList<>();
        for(Long id : ids) {
            RecipeDTO recipe = recipeService.findRecipyById(id);
            List<RecipeIngredientDTO> recipeIngredientDTOS = getIngredientsForRecipe(id);
            for (RecipeIngredientDTO recipeIngredientDTO : recipeIngredientDTOS) {
                Ingredient ingredient = ingredientEntityService.getIngredientEntity(recipeIngredientDTO.getIngredientId());
                dto.add(new RecipeIngredientNameDTO(id,
                                                    ingredient.getName(),
                                                    ingredient.getUnit(),
                                                    recipeIngredientDTO.getAmount()/ recipe.getNoPortions()));
            }
        }
        return dto;
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
