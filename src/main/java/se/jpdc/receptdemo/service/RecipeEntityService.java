package se.jpdc.receptdemo.service;

import se.jpdc.receptdemo.model.Recipe;

public abstract class RecipeEntityService {

    protected abstract Recipe getRecipyEntity(Long id);

}
