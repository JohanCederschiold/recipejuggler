package se.jpdc.receptdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jpdc.receptdemo.database.IngredientsRepository;
import se.jpdc.receptdemo.model.Ingredient;
import se.jpdc.receptdemo.model.IngredientDTO;

@Service
public class IngredientServiceImpl extends IngredientEntityService implements IngredientService {

    @Autowired
    IngredientsRepository repo;

    @Override
    public IngredientDTO addNewIngredient(Ingredient ingredient) {

        Ingredient foundIngredient = repo.findByName(ingredient.getName());

        if (foundIngredient == null ) {
            foundIngredient = repo.save(ingredient);
        }

        return convertToDto(foundIngredient);

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
}
