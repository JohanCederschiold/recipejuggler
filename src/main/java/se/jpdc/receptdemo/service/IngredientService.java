package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.Ingredient;
import se.jpdc.receptdemo.model.IngredientDTO;

import java.util.List;

public interface IngredientService {

    public IngredientDTO addNewIngredient(Ingredient ingredient);
    public void deleteIngredient(Long id);
    public IngredientDTO updateIngredient(IngredientDTO ingredientDTO);
    public List<IngredientDTO> getAllIngredients();
    public IngredientDTO getIngredientById(Long id);
    public IngredientDTO getIngredientsByName(String name);

}
