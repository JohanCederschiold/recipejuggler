package se.jpdc.receptdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Recipe recipe;

    private String name; //Todo: This should be change to it's own entity to alleviate searching for ingredients.
    private double amount;
}
