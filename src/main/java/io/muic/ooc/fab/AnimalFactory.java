package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class AnimalFactory {

    private static final HashMap<AnimalType, Class<? extends Animal>> ANIMAL_MAPPING = new HashMap<>();

    static{
        ANIMAL_MAPPING.put(AnimalType.RABBIT, Rabbit.class);
        ANIMAL_MAPPING.put(AnimalType.FOX, Fox.class);
    }

    public static Animal createAnimal(AnimalType animalType, boolean randomAge, Location location, Field field){
        try{
            return ANIMAL_MAPPING.get(animalType).getDeclaredConstructor(boolean.class, Location.class, Field.class).newInstance(randomAge, location, field);
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
           e.printStackTrace();
       }


        throw new RuntimeException("unknown animal type");
    }

}
