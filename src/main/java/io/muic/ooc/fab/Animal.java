package io.muic.ooc.fab;

public abstract class Animal {



    // Individual characteristics (instance fields).
    // The rabbit's age.
    private int age;
    // Whether the rabbit is alive or not.
    private boolean alive = true;

    /**
     * Indicate that the rabbit is no longer alive. It is removed from the
     * field.
     */
    protected abstract void setDead();
    protected abstract int getMaxAge();
    protected abstract int getBreedingAge();


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
}
