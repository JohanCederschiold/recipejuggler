package se.jpdc.receptdemo.model;

import java.util.List;

public class CompleteRecipeDTO {

    private Long recipeId;
    private String title;
    private String owner;
    private int preparationTimeMinutes;
    private int noPortions;
    private String instructions;
    private List<IngredientAmountDTO> ingredients;
    private List<StepDTO> steps;

    public CompleteRecipeDTO(Long recipeId, String title, String owner,
                             int preparationTimeMinutes, int noPortions, String instructions,
                             List<IngredientAmountDTO> ingredients, List<StepDTO> steps) {
        this.recipeId = recipeId;
        this.title = title;
        this.owner = owner;
        this.preparationTimeMinutes = preparationTimeMinutes;
        this.noPortions = noPortions;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    public int getPreparationTimeMinutes() {
        return preparationTimeMinutes;
    }

    public int getNoPortions() {
        return noPortions;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<IngredientAmountDTO> getIngredients() {
        return ingredients;
    }

    public List<StepDTO> getSteps() {
        return steps;
    }
}
