package se.jpdc.receptdemo.model;

import lombok.Data;

@Data
public class RecipeIngredientWrapper {

    private Long recipeId;
    private Long ingredientId;
    private double amount;

}
