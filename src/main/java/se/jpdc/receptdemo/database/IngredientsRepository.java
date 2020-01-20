package se.jpdc.receptdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jpdc.receptdemo.model.Ingredient;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findByNameIgnoreCase(String ingredientName);

}
