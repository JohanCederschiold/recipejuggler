package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.IngredientsRepository;
import se.jpdc.receptdemo.model.Ingredient;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientsRepository repo;

    @Override
    public void addNewIngredient(Ingredient ingredient) {

        Ingredient foundIngredient = repo.findByName(ingredient.getName());

        if (foundIngredient == null ) {
            repo.save(ingredient);
        }

    }
}
