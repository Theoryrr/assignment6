/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Acrobatic class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AcrobaticTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Acrobatic a = new Acrobatic("Dan", 19, 3, "Acrobat", "acro.jpg");

        assertEquals("Dan", a.getName());
        assertEquals(19, a.getAge());
        assertEquals(3, a.getYearsWorked());
        assertEquals("Acrobat", a.getJob());
        assertEquals("acro.jpg", a.getImagePath());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Acrobatic a = new Acrobatic("Dan", 19, 3, "Acrobat", "acro.jpg");
        String text = a.toString();

        assertTrue(text.contains("Acrobatic"));
        assertTrue(text.contains("Dan"));
    }
}