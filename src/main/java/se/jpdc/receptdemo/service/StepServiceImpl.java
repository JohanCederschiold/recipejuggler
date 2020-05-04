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


    public void updateRecipeSteps2(StepsWrapper steps) {

    //    Delete steps that are not found in the new array
        //Long recipeId = steps.getSteps().get(0).getRecipeid(); //Get recipe id
        Long recipeId = steps.getRecipeId();
        List<Step> currentSteps = repo.getStepsByRecipeId(recipeId); //Get current recipesteps
        for (Step step : currentSteps) { //Iterate over current recipesteps and check if they are in the new list
            boolean foundStep = false;
            StepDTO matchingDTO = null;
            for(StepDTO dto : steps.getSteps()) {
                if (dto.getId() == step.getId()) {
                    foundStep = true;
                    matchingDTO = dto;
                }
            }
            if (!foundStep) {
                //Step not found - Delete from repo
                System.out.println("Not found: " + step.getInstruction());
                repo.delete(repo.getOne(step.getId()));
            } else {
                //Step found - Update step in repo
                System.out.println("Found: " + step.getInstruction());
                Step stepToUpdate = repo.getOne(step.getId());
                stepToUpdate.setInstruction(matchingDTO.getInstruction());
                stepToUpdate.setSequence(matchingDTO.getSequence());
                repo.save(stepToUpdate);
            }
        }

        for(StepDTO dto : steps.getSteps()) {
            if (dto.getId() == null) {
                System.out.println("New step: " + dto.getInstruction());
                Step newStep = new Step();
                newStep.setSequence(dto.getSequence());
                newStep.setInstruction(dto.getInstruction());
                newStep.setRecipe(recipeEntityService.getRecipyEntity(recipeId));
                repo.save(newStep);
            }
        }
    }

    @Override
    public void updateRecipeSteps (StepsWrapper steps) {

        List<Step> currentSteps = repo.getStepsByRecipeId(steps.getRecipeId());
        Recipe recipe = recipeEntityService.getRecipyEntity(steps.getRecipeId());
        for (Step step : currentSteps) {
            repo.deleteById(step.getId());
        }

        for(StepDTO newStep : steps.getSteps()) {
            Step registerStep = new Step();
            registerStep.setSequence(newStep.getSequence());
            registerStep.setInstruction(newStep.getInstruction());
            registerStep.setRecipe(recipe);
            repo.save(registerStep);
        }
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
