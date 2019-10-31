package se.jpdc.receptdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String owner;
    private int preparationTimeMinutes;
    private int noPortions;
    private String instructions;

    @OneToMany
    private Set<Ingredients> ingredients;


}
