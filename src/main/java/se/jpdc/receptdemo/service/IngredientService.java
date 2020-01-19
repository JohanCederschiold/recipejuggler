package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.Ingredient;
import se.jpdc.receptdemo.model.IngredientDTO;

public interface IngredientService {

    public IngredientDTO addNewIngredient(Ingredient ingredient);

}
