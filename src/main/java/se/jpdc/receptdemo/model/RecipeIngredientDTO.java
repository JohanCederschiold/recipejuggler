package se.jpdc.receptdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RecipeIngredientDTO {

    private Long id;
    private Long recipeId;
    private Long ingredientId;
    private double amount;



}
