package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.IngredientsRepo;
import se.jpdc.receptdemo.model.IngredientDTO;
import se.jpdc.receptdemo.model.Ingredients;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientsRepo repo;

    @Override
    public void addIngredient(IngredientDTO ingredientDTO) {
        repo.save(convertFromDTO(ingredientDTO));
    }


    private Ingredients convertFromDTO (IngredientDTO ingredientDTO) {
        Ingredients ingredient = new Ingredients();
        ingredient.setName(ingredientDTO.getName());
        return ingredient;
    }

}
