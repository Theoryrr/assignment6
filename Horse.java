/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents a horse in the circus. Implements Animal and Cloneable.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class Horse implements Animal, Cloneable {
    private String name;
    private int age;
    private String species;
    private String color;
    private String imagePath;

    /*
     * Constructor
     * Stores all horse information in the object.
     */
    public Horse(String name, int age, String species, String color, String imagePath) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
        this.imagePath = imagePath;
    }

    /*
     * makeSound
     * Prints the sound this animal makes.
     */
    @Override
    public void makeSound() {
        System.out.println("Neigh!");
    }

    /*
     * move
     * Prints how this animal moves.
     */
    @Override
    public void move() {
        System.out.println("Gallops around.");
    }

    /*
     * getName
     * Returns the horse's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * getAge
     * Returns the horse's age.
     */
    @Override
    public int getAge() {
        return age;
    }

    /*
     * getSpecies
     * Returns the horse's species.
     */
    @Override
    public String getSpecies() {
        return species;
    }

    /*
     * getColor
     * Returns the horse's color.
     */
    @Override
    public String getColor() {
        return color;
    }

    /*
     * getImagePath
     * Returns the image path used in the GUI.
     */
    @Override
    public String getImagePath() {
        return imagePath;
    }

    /*
     * clone
     * Returns a new Horse object with the same field values.
     */
    @Override
    public Horse clone() {
        return new Horse(name, age, species, color, imagePath);
    }

    /*
     * toString
     * Returns a readable description of the horse.
     */
    @Override
    public String toString() {
        return "Horse [Name: " + name + ", Age: " + age + ", Species: " + species
                + ", Color: " + color + ", Image: " + imagePath + "]";
    }
}