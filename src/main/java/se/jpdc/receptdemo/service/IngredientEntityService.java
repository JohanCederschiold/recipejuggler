package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.Ingredient;

public abstract class IngredientEntityService {

    protected abstract Ingredient getIngredientEntity (Long id);

}
