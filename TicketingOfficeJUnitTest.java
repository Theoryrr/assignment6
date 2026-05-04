/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for the TicketingOffice class.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {

    /*
     * Tests constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        TicketingOffice t = new TicketingOffice("White", 220.0, 134.0, "office.jpg");

        assertEquals("White", t.getColor());
        assertEquals(220.0, t.getLength(), 0.001);
        assertEquals(134.0, t.getWidth(), 0.001);
        assertEquals("Ticketing Office", t.getBuildingType());
        assertEquals("office.jpg", t.getImagePath());
    }

    /*
     * Tests setter methods.
     */
    @Test
    public void testSetters() {
        TicketingOffice t = new TicketingOffice("White", 220.0, 134.0, "office.jpg");

        t.setColor("Gray");
        t.setSize(250.0, 140.0);
        t.setBuildingType("Front Office");

        assertEquals("Gray", t.getColor());
        assertEquals(250.0, t.getLength(), 0.001);
        assertEquals(140.0, t.getWidth(), 0.001);
        assertEquals("Front Office", t.getBuildingType());
    }

    /*
     * Tests toString returns useful text.
     */
    @Test
    public void testToString() {
        TicketingOffice t = new TicketingOffice("White", 220.0, 134.0, "office.jpg");
        String text = t.toString();

        assertTrue(text.contains("Ticketing Office"));
        assertTrue(text.contains("White"));
    }
}