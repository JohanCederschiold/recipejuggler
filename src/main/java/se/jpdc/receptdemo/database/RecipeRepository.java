package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jpdc.receptdemo.model.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    public List<Recipe> findRecipesByTitleIgnoreCase(String title);
    public List<Recipe> findRecipesByOwnerIgnoreCase(String owner);

}
