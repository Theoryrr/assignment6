/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Horse class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HorseJUnitTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Horse h = new Horse("Star", 3, "Horse", "Brown", "horse.jpg");

        assertEquals("Star", h.getName());
        assertEquals(3, h.getAge());
        assertEquals("Horse", h.getSpecies());
        assertEquals("Brown", h.getColor());
        assertEquals("horse.jpg", h.getImagePath());
    }

    /*
     * Tests clone method.
     */
    @Test
    public void testClone() {
        Horse h1 = new Horse("Star", 3, "Horse", "Brown", "horse.jpg");
        Horse h2 = h1.clone();

        assertNotSame(h1, h2);
        assertEquals(h1.getName(), h2.getName());
        assertEquals(h1.getAge(), h2.getAge());
        assertEquals(h1.getSpecies(), h2.getSpecies());
        assertEquals(h1.getColor(), h2.getColor());
        assertEquals(h1.getImagePath(), h2.getImagePath());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Horse h = new Horse("Star", 3, "Horse", "Brown", "horse.jpg");
        String text = h.toString();

        assertTrue(text.contains("Star"));
        assertTrue(text.contains("Horse"));
    }
}