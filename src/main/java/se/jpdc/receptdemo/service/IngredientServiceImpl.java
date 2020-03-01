package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.IngredientsRepository;
import se.jpdc.receptdemo.model.Ingredient;
import se.jpdc.receptdemo.model.IngredientDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl extends IngredientEntityService implements IngredientService {

    @Autowired
    IngredientsRepository repo;

    @Override
    public IngredientDTO addNewIngredient(Ingredient ingredient) {

        Ingredient foundIngredient = repo.findByNameIgnoreCase(ingredient.getName());
        if (foundIngredient == null ) {
            foundIngredient = repo.save(ingredient);
        }
        return convertToDto(foundIngredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        Ingredient ingredientToDelete = repo.getOne(id);
        repo.delete(ingredientToDelete);
    }

    @Override
    public IngredientDTO updateIngredient(IngredientDTO ingredientDTO) {
        Ingredient originalIngredient = repo.getOne(ingredientDTO.getId());

        if(ingredientDTO.getName() != null ) {
            originalIngredient.setName(ingredientDTO.getName());
        }

        if(ingredientDTO.getUnits() != null) {
            originalIngredient.setUnit(ingredientDTO.getUnits());
        }

        Ingredient updatedIngredient = repo.save(originalIngredient);

        return convertToDto(updatedIngredient);
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        List<Ingredient> ingredients = repo.findAll();
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        for(Ingredient ingredient : ingredients) {
            ingredientDTOS.add(convertToDto(ingredient));
        }
        return ingredientDTOS;
    }

    @Override
    public IngredientDTO getIngredientById(Long id) {
        return convertToDto(repo.getOne(id));
    }

    @Override
    public IngredientDTO getIngredientsByName(String name) {
        return convertToDto(repo.findByNameIgnoreCase(name));
    }

    private IngredientDTO convertToDto (Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setId(ingredient.getId());
        dto.setName(ingredient.getName());
        dto.setUnits(ingredient.getUnit());
        return dto;
    }

    @Override
    protected Ingredient getIngredientEntity(Long id) {
        return repo.getOne(id);
    }

    @Override
    protected Ingredient getIngredientEntityByName(String name) {
        return repo.findByNameIgnoreCase(name);
    }
}
