/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents a bird in the circus. Implements Animal and Cloneable.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class Bird implements Animal, Cloneable {
    private String name;
    private int age;
    private String species;
    private String color;
    private String imagePath;

    /*
     * Constructor
     * Stores all bird information in the object.
     */
    public Bird(String name, int age, String species, String color, String imagePath) {
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
        System.out.println("Chirp!");
    }

    /*
     * move
     * Prints how this animal moves.
     */
    @Override
    public void move() {
        System.out.println("Flies around.");
    }

    /*
     * getName
     * Returns the bird's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /*
     * getAge
     * Returns the bird's age.
     */
    @Override
    public int getAge() {
        return age;
    }

    /*
     * getSpecies
     * Returns the bird's species.
     */
    @Override
    public String getSpecies() {
        return species;
    }

    /*
     * getColor
     * Returns the bird's color.
     */
    @Override
    public String getColor() {
        return color;
    }

    /*
     * getImagePath
     * Returns the file path of the image used in the GUI.
     */
    @Override
    public String getImagePath() {
        return imagePath;
    }

    /*
     * clone
     * Returns a new Bird object with the same field values.
     */
    @Override
    public Bird clone() {
        return new Bird(name, age, species, color, imagePath);
    }

    /*
     * toString
     * Returns a readable description of the bird.
     */
    @Override
    public String toString() {
        return "Bird [Name: " + name + ", Age: " + age + ", Species: " + species
                + ", Color: " + color + ", Image: " + imagePath + "]";
    }
}