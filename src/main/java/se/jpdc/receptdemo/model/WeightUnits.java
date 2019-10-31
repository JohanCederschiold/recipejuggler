package se.jpdc.receptdemo.model;

public enum WeightUnits {

    KG("Kilogram",1000000L, MeasureUnits.WEIGHT),
    HG("HeKtoGram",100000L, MeasureUnits.WEIGHT),
    GR("Gram", 1000L, MeasureUnits.WEIGHT),
    MG ("Miligram",1L, MeasureUnits.WEIGHT);

    private Long mgs;
    private String name;
    private MeasureUnits measureUnit;

    WeightUnits(String name, Long mgs, MeasureUnits measureUnit) {
        this.mgs = mgs;
        this.name = name;
        this.measureUnit = measureUnit;
    }
}
