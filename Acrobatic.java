/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents an acrobatic worker in the circus. Extends the abstract Person class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class Acrobatic extends Person {

    /*
     * Constructor
     * Sends all common person data to the Person superclass constructor.
     */
    public Acrobatic(String name, int age, int yearsWorked, String job, String imagePath) {
        super(name, age, yearsWorked, job, imagePath);
    }

    /*
     * toString
     * Adds the specific role name before the inherited Person information.
     */
    @Override
    public String toString() {
        return "Acrobatic - " + super.toString();
    }
}