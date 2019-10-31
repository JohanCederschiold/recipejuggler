package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import se.jpdc.receptdemo.model.Ingredients;

public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {
}
