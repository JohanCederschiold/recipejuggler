package se.jpdc.receptdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private Ingredient ingredient;
    private double amount;
}
