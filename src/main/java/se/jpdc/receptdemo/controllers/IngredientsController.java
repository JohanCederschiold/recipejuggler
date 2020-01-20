package se.jpdc.receptdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.jpdc.receptdemo.model.Ingredient;
import se.jpdc.receptdemo.model.IngredientDTO;
import se.jpdc.receptdemo.model.RecipeIngredient;
import se.jpdc.receptdemo.service.IngredientService;
import se.jpdc.receptdemo.service.RecipeIngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientsController {

    @Autowired
    IngredientService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient) {
        return service.addNewIngredient(ingredient);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteIngredient (@PathVariable Long id) {
        service.deleteIngredient(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public IngredientDTO updateIngredient(@RequestBody IngredientDTO ingredientDTO) {
        return service.updateIngredient(ingredientDTO);
    }

    @GetMapping("/all")
    public List<IngredientDTO> getAllIngredients() {
        return service.getAllIngredients();
    }

    @GetMapping("/find/name/{name}")
    public IngredientDTO getIngredientByName(@PathVariable String name) {
        return service.getIngredientsByName(name);
    }

    @GetMapping("/find/id/{id}")
    public IngredientDTO getIngredientById(@PathVariable Long id) {
        return service.getIngredientById(id);
    }

}
