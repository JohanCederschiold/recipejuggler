package se.jpdc.receptdemo.model;

public class IngredientAmountDTO {

    private String ingredientName;
    private MeasureUnits units;
    private double amount;

    public IngredientAmountDTO(String ingredientName, MeasureUnits units, double amount) {
        this.ingredientName = ingredientName;
        this.units = units;
        this.amount = amount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public MeasureUnits getUnits() {
        return units;
    }

    public double getAmount() {
        return amount;
    }
}
