package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.StepsRepository;
import se.jpdc.receptdemo.model.Recipe;
import se.jpdc.receptdemo.model.Step;
import se.jpdc.receptdemo.model.StepDTO;
import se.jpdc.receptdemo.model.StepsWrapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    StepsRepository repo;

    @Autowired
    RecipeEntityService recipeEntityService;

    @Override
    public List<StepDTO> registerSteps(StepsWrapper steps) {
        Recipe recipe = recipeEntityService.getRecipyEntity(steps.getRecipeId());
        List<StepDTO> dtos = new ArrayList<>();
        for (StepDTO dto : steps.getSteps()) {
            Step step = new Step();
            step.setSequence(dto.getSequence());
            step.setInstruction(dto.getInstruction());
            step.setRecipe(recipe);
            Step savedStep = repo.save(step);
            dtos.add(convertToDto(savedStep));
        }
        return dtos;
    }

    @Override
    public List<StepDTO> getStepsToRecipeByRecipeId(Long recipeId) {
        List<Step> steps = repo.getStepsByRecipeId(recipeId);
        List<StepDTO> convertedSteps = new ArrayList<>();
        for (Step step : steps) {
            convertedSteps.add(convertToDto(step));
        }
        return convertedSteps;
    }

    @Override
    @Transactional
    public void deleteStepsRelatedToRecipeByRecipeId(Long recipeId) {
        repo.deleteStepsByRecipeId(recipeId);
    }

    private StepDTO convertToDto(Step step) {
        StepDTO dto = new StepDTO();
        dto.setId(step.getId());
        dto.setInstruction(step.getInstruction());
        dto.setRecipeid(step.getRecipe().getId());
        dto.setSequence(step.getSequence());
        return dto;
    }
}
