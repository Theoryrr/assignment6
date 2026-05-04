/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Clerk class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClerkTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Clerk c = new Clerk("Fred", 16, 1, "Accountant", "clerk.jpg");

        assertEquals("Fred", c.getName());
        assertEquals(16, c.getAge());
        assertEquals(1, c.getYearsWorked());
        assertEquals("Accountant", c.getJob());
        assertEquals("clerk.jpg", c.getImagePath());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Clerk c = new Clerk("Fred", 16, 1, "Accountant", "clerk.jpg");
        String text = c.toString();

        assertTrue(text.contains("Clerk"));
        assertTrue(text.contains("Fred"));
    }
}