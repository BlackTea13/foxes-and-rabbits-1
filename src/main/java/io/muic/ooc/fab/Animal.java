package io.muic.ooc.fab;

import java.util.Random;

public abstract class Animal {

    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();

    // Individual characteristics (instance fields).
    // The rabbit's age.
    private int age;
    // Whether the rabbit is alive or not.
    private boolean alive = true;
    // The rabbit's position.
    private Location location;
    // The field occupied.
    private Field field;


    public Animal(boolean randomAge, Location location, Field field) {
        this.field = field;
        setLocation(location);
        if (randomAge) {
            setAge(RANDOM.nextInt(getMaxAge()));
        }
    }

    protected abstract int getMaxAge();
    protected abstract int getBreedingAge();
    protected abstract int getMaxLitterSize();
    protected abstract double getBreedingProbability();

    /**
     * Place the rabbit at the new location in the given field.
     *
     * @param newLocation The rabbit's new location.
     */
    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Indicate that the rabbit is no longer alive. It is removed from the
     * field.
     */
    protected void setDead() {
        setAlive(false);
        if (getField() != null) {
            getField().clear(getLocation());
            location = null;
            field = null;
        }
    }


    /**
     * Increase the age. This could result in the rabbit's death.
     */
    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    /**
     * A fox can breed if it has reached the breeding age.
     */
    protected boolean canBreed(){
        return getAge() >= getBreedingAge();
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Location getLocation() {
        return location;
    }

    public Field getField() {
        return field;
    }
}
