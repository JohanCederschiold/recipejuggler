package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.RecipeRepository;
import se.jpdc.receptdemo.model.Ingredients;
import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.RecipeDTO;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository repo;

    @Autowired
    IngredientService ingredientService;



    @Override
    public void addRecipe(RecipeDTO recipe) {
        repo.save(convertFromDTO(recipe));
    }

    @Override
    public void addIngredientToRecipe(long recipeId, Ingredients ingredients) {

        ingredientService.addIngredient(ingredients);
        Recipe recipe = repo.getOne(recipeId);
        recipe.getIngredients().add(ingredients);
        repo.save(recipe);
    }


    public Recipe convertFromDTO (RecipeDTO recipeDTO) {

        Recipe recipeToSave = new Recipe();
        recipeToSave.setOwner(recipeDTO.getOwner());
        recipeToSave.setTitle(recipeDTO.getTitle());
        return recipeToSave;
    }
 }
