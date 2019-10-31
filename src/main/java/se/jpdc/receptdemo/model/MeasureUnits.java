package se.jpdc.receptdemo.model;

public enum MeasureUnits {

    Kg("Kilogram",1000000L),
    Hg("HectoGram",100000L),
    G("Gram", 1000L),
    Mg ("Miligram",1L);

    private Long mgs;
    private String name;

    MeasureUnits(String name, Long milliGrams) {
        this.mgs = milliGrams;
        this.name = name;
    }

}
