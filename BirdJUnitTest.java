/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Bird class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BirdJUnitTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Bird b = new Bird("Rio", 2, "Parrot", "Green", "bird.jpg");

        assertEquals("Rio", b.getName());
        assertEquals(2, b.getAge());
        assertEquals("Parrot", b.getSpecies());
        assertEquals("Green", b.getColor());
        assertEquals("bird.jpg", b.getImagePath());
    }

    /*
     * Tests clone method.
     */
    @Test
    public void testClone() {
        Bird b1 = new Bird("Rio", 2, "Parrot", "Green", "bird.jpg");
        Bird b2 = b1.clone();

        assertNotSame(b1, b2);
        assertEquals(b1.getName(), b2.getName());
        assertEquals(b1.getAge(), b2.getAge());
        assertEquals(b1.getSpecies(), b2.getSpecies());
        assertEquals(b1.getColor(), b2.getColor());
        assertEquals(b1.getImagePath(), b2.getImagePath());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Bird b = new Bird("Rio", 2, "Parrot", "Green", "bird.jpg");
        String text = b.toString();

        assertTrue(text.contains("Rio"));
        assertTrue(text.contains("Parrot"));
    }
}