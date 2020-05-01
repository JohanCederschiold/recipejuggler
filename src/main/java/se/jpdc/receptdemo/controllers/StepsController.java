package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.jpdc.receptdemo.model.StepDTO;
import se.jpdc.receptdemo.model.StepsWrapper;
import se.jpdc.receptdemo.service.StepService;

import java.util.List;

@RestController
@RequestMapping("/steps")
public class StepsController {

    @Autowired
    StepService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public List<StepDTO> registerSteps(@RequestBody StepsWrapper steps) {
        return service.registerSteps(steps);
    }

    @GetMapping("/find/recipesteps/{id}")
    public List<StepDTO> getRecipeSteps(@PathVariable Long id) {
        return service.getStepsToRecipeByRecipeId(id);
    }

    @DeleteMapping("/delete/recipeid/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStepsToRecipe(@PathVariable Long id) {
        service.deleteStepsRelatedToRecipeByRecipeId(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRecipeSteps(@RequestBody StepsWrapper steps) {
        System.out.println(steps.getRecipeId());
        for(StepDTO dtop : steps.getSteps()) {
            System.out.println(dtop);
        }
        service.updateRecipeSteps(steps);
    }

}
