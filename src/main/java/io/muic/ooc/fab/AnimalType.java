package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    FOX(Fox.class, Color.BLUE, 0.02),
    RABBIT(Rabbit.class, Color.ORANGE, 0.08);

    private Class<? extends Animal> animalClass;
    private Color color;
    private double probability;

    AnimalType(Class<? extends Animal> animalClass, Color color, double probability){
        this.animalClass = animalClass;
        this.color = color;
        this.probability = probability;
    }

    public Class<? extends Animal> getAnimalClass(){
        return this.animalClass;
    }

    public Color getColor(){
        return this.color;
    }
}
