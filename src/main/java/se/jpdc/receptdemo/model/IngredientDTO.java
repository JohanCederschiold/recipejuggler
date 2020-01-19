package se.jpdc.receptdemo.model;

import lombok.Data;

@Data
public class IngredientDTO {

    private Long id;
    private String name;
    private MeasureUnits units;
}
