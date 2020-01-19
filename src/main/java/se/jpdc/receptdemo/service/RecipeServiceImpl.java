package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.RecipeRepository;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.RecipeDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl extends RecipeEntityService implements RecipeService {

    @Autowired
    RecipeRepository repo;


    @Override
    public RecipeDTO addRecipe(Recipe recipe) {
        Recipe storedRecipe = repo.save(recipe);
        return convertToDto(storedRecipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        Recipe recipeToDelete = repo.getOne(id);
        repo.delete(recipeToDelete);
    }

    @Override
    public RecipeDTO updateRecipe(Recipe recipe) {
        System.out.println(recipe.getId());
        System.out.println(recipe.getOwner());
        Recipe originalRecipe = repo.getOne(recipe.getId());
        if (recipe.getOwner() != null) {
            originalRecipe.setOwner(recipe.getOwner());
        }

        if (recipe.getTitle() != null) {
            originalRecipe.setTitle(recipe.getTitle());
        }

        repo.save(originalRecipe);

        return convertToDto(originalRecipe);
    }

    @Override
    public RecipeDTO findRecipyById(Long id) {
        return convertToDto(repo.getOne(id));
    }

    @Override
    public List<RecipeDTO> findRecipeByName(String name) {
        List<Recipe> recipes = repo.findRecipesByTitleIgnoreCase(name);
        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        for(Recipe recipe : recipes) {
            recipeDTOS.add(convertToDto(recipe));
        }
        return recipeDTOS;
    }

    @Override
    public List<RecipeDTO> findRecipiesByOwner(String ownerName) {
        List<Recipe> recipes = repo.findRecipesByOwnerIgnoreCase(ownerName);
        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        for(Recipe recipe : recipes) {
            recipeDTOS.add(convertToDto(recipe));
        }
        return recipeDTOS;
    }

    public Recipe convertFromDTO (RecipeDTO recipeDTO) {
        Recipe recipeToSave = new Recipe();
        recipeToSave.setOwner(recipeDTO.getOwner());
        recipeToSave.setTitle(recipeDTO.getTitle());
        return recipeToSave;
    }

    private RecipeDTO convertToDto(Recipe recipe ) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setOwner(recipe.getOwner());
        dto.setTitle(recipe.getTitle());
        return dto;
    }

    @Override
    protected Recipe getRecipyEntity(Long id) {
        return repo.getOne(id);
    }
}
