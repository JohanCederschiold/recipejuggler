package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.model.RecipeIngredientDTO;

import java.util.List;

public interface RecipeIngredientsRepo extends JpaRepository<RecipeIngredient, Long> {

    public List<RecipeIngredient> findRecipeIngredientsByRecipe(Long id);
    public List<RecipeIngredient> findRecipeIngredientsByRecipe_Id(Long id);


}
