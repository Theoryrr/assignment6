/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Lion class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LionJUnitTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Lion l = new Lion("Leo", 6, "Lion", "Brown", "lion.jpg");

        assertEquals("Leo", l.getName());
        assertEquals(6, l.getAge());
        assertEquals("Lion", l.getSpecies());
        assertEquals("Brown", l.getColor());
        assertEquals("lion.jpg", l.getImagePath());
    }

    /*
     * Tests clone method.
     */
    @Test
    public void testClone() {
        Lion l1 = new Lion("Leo", 6, "Lion", "Brown", "lion.jpg");
        Lion l2 = l1.clone();

        assertNotSame(l1, l2);
        assertEquals(l1.getName(), l2.getName());
        assertEquals(l1.getAge(), l2.getAge());
        assertEquals(l1.getSpecies(), l2.getSpecies());
        assertEquals(l1.getColor(), l2.getColor());
        assertEquals(l1.getImagePath(), l2.getImagePath());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Lion l = new Lion("Leo", 6, "Lion", "Brown", "lion.jpg");
        String text = l.toString();

        assertTrue(text.contains("Leo"));
        assertTrue(text.contains("Lion"));
    }
}