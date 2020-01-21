package se.jpdc.receptdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class StepsWrapper {

    private Long recipeId;
    private List<StepDTO> steps;

}
