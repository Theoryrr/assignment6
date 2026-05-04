/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents a lion in the circus. Implements Animal and Cloneable.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class Lion implements Animal, Cloneable {
    private String name;
    private int age;
    private String species;
    private String color;
    private String imagePath;

    /*
     * Constructor
     * Stores all lion information in the object.
     */
    public Lion(String name, int age, String species, String color, String imagePath) {
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
        System.out.println("Roar!");
    }

    /*
     * move
     * Prints how this animal moves.
     */
    @Override
    public void move() {
        System.out.println("Runs proudly.");
    }

    /*
     * getName
     * Returns the lion's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * getAge
     * Returns the lion's age.
     */
    @Override
    public int getAge() {
        return age;
    }

    /*
     * getSpecies
     * Returns the lion's species.
     */
    @Override
    public String getSpecies() {
        return species;
    }

    /*
     * getColor
     * Returns the lion's color.
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
     * Returns a new Lion object with the same field values.
     */
    @Override
    public Lion clone() {
        return new Lion(name, age, species, color, imagePath);
    }

    /*
     * toString
     * Returns a readable description of the lion.
     */
    @Override
    public String toString() {
        return "Lion [Name: " + name + ", Age: " + age + ", Species: " + species
                + ", Color: " + color + ", Image: " + imagePath + "]";
    }
}