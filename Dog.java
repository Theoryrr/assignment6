/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents a dog in the circus. Implements Animal and Cloneable.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class Dog implements Animal, Cloneable {
    private String name;
    private int age;
    private String species;
    private String color;
    private String imagePath;

    /*
     * Constructor
     * Stores all dog information in the object.
     */
    public Dog(String name, int age, String species, String color, String imagePath) {
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
        System.out.println("Woof!");
    }

    /*
     * move
     * Prints how this animal moves.
     */
    @Override
    public void move() {
        System.out.println("Runs around.");
    }

    /*
     * getName
     * Returns the dog's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * getAge
     * Returns the dog's age.
     */
    @Override
    public int getAge() {
        return age;
    }

    /*
     * getSpecies
     * Returns the dog's species.
     */
    @Override
    public String getSpecies() {
        return species;
    }

    /*
     * getColor
     * Returns the dog's color.
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
     * Returns a new Dog object with the same field values.
     */
    @Override
    public Dog clone() {
        return new Dog(name, age, species, color, imagePath);
    }

    /*
     * toString
     * Returns a readable description of the dog.
     */
    @Override
    public String toString() {
        return "Dog [Name: " + name + ", Age: " + age + ", Species: " + species
                + ", Color: " + color + ", Image: " + imagePath + "]";
    }
}