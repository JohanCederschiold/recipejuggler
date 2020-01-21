package se.jpdc.receptdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer sequence;
    private String instruction;

    @ManyToOne
    private Recipe recipe;

}
