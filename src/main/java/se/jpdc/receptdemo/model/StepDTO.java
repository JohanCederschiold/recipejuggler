package se.jpdc.receptdemo.model;

import lombok.Data;

@Data
public class StepDTO {

    private Long id;
    private Integer sequence;
    private String instruction;
    private Long recipeid;

}
