package se.jpdc.receptdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class RecipeIdWrapper {

    private List<Long> recipeIds;
}
