package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import se.jpdc.receptdemo.model.RecipeIngredient;

public interface IngredientsRepo extends JpaRepository<RecipeIngredient, Long> {
}
