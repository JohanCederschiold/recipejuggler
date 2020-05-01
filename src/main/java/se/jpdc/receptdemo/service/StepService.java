package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.StepDTO;
import se.jpdc.receptdemo.model.StepsWrapper;

import java.util.List;

public interface StepService {

    public List<StepDTO> registerSteps(StepsWrapper steps);
    public List<StepDTO> getStepsToRecipeByRecipeId(Long recipeId);
    public void deleteStepsRelatedToRecipeByRecipeId(Long recipeId);
    public void updateRecipeSteps(StepsWrapper steps);

}
