package se.jpdc.receptdemo.model;

public enum VolumeUnits {

    KRM("Kryddmått", 1L, MeasureUnits.VOLUME),
    MIL("Mililiter", 1L, MeasureUnits.VOLUME),
    TSK("Tesked", 5L, MeasureUnits.VOLUME),
    CEL("Centiliter", 10L, MeasureUnits.VOLUME),
    MSK("Matsked", 15L, MeasureUnits.VOLUME),
    DCL("Deciliter", 100L, MeasureUnits.VOLUME),
    LIT("Liter", 1000L, MeasureUnits.VOLUME);

    private String name;
    private Long ml;
    private MeasureUnits measureUnit;

    VolumeUnits(String name, Long ml, MeasureUnits measureUnit) {
        this.name = name;
        this.ml = ml;
        this.measureUnit = measureUnit;
    }
}
