package io.muic.ooc.fab;

public class AnimalFactory {

    public static Animal createAnimal(AnimalType animalType, boolean randomAge, Location location, Field field){
        if (animalType.equals(AnimalType.FOX)) {
            return new Fox(true, field, location);
        } else if (animalType.equals(AnimalType.RABBIT)) {
            return new Rabbit(true, field, location);
        }

        else{
            throw new RuntimeException("Unknown animal type");
        }
    }

}
