package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jpdc.receptdemo.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
