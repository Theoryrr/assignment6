/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the Arena class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArenaJUnitTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        Arena a = new Arena("Red", 200.0, 100.0, "arena.jpg");

        assertEquals("Red", a.getColor());
        assertEquals(200.0, a.getLength(), 0.001);
        assertEquals(100.0, a.getWidth(), 0.001);
        assertEquals("Arena", a.getBuildingType());
        assertEquals("arena.jpg", a.getImagePath());
    }

    /*
     * Tests setter methods.
     */
    @Test
    public void testSetters() {
        Arena a = new Arena("Red", 200.0, 100.0, "arena.jpg");

        a.setColor("Blue");
        a.setSize(300.0, 150.0);
        a.setBuildingType("Main Arena");

        assertEquals("Blue", a.getColor());
        assertEquals(300.0, a.getLength(), 0.001);
        assertEquals(150.0, a.getWidth(), 0.001);
        assertEquals("Main Arena", a.getBuildingType());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        Arena a = new Arena("Red", 200.0, 100.0, "arena.jpg");
        String text = a.toString();

        assertTrue(text.contains("Arena"));
        assertTrue(text.contains("Red"));
    }
}