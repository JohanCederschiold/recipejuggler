package se.jpdc.receptdemo.model;

import lombok.Data;

@Data
public class RecipeDTO {

    private Long id;
    private String title;
    private String owner;
    private int preparationTimeMinutes;
    private int noPortions;
    private String instructions;
}
