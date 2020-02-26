package se.jpdc.receptdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeIngredientNameDTO {

    private Long recipeId;
    private String ingredientName;
    private MeasureUnits units;
    private double amount;

}
