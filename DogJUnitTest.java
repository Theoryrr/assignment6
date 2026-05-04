/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Dog class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DogJUnitTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Dog d = new Dog("Max", 4, "Poodle", "White", "dog.jpg");

        assertEquals("Max", d.getName());
        assertEquals(4, d.getAge());
        assertEquals("Poodle", d.getSpecies());
        assertEquals("White", d.getColor());
        assertEquals("dog.jpg", d.getImagePath());
    }

    /*
     * Tests clone method.
     */
    @Test
    public void testClone() {
        Dog d1 = new Dog("Max", 4, "Poodle", "White", "dog.jpg");
        Dog d2 = d1.clone();

        assertNotSame(d1, d2);
        assertEquals(d1.getName(), d2.getName());
        assertEquals(d1.getAge(), d2.getAge());
        assertEquals(d1.getSpecies(), d2.getSpecies());
        assertEquals(d1.getColor(), d2.getColor());
        assertEquals(d1.getImagePath(), d2.getImagePath());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Dog d = new Dog("Max", 4, "Poodle", "White", "dog.jpg");
        String text = d.toString();

        assertTrue(text.contains("Max"));
        assertTrue(text.contains("Poodle"));
    }
}