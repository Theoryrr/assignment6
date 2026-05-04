/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for Circus class features used by the driver app.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JUnit 6
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CircusDriverAppJUnitTest {

    /*
     * Tests animal search works.
     */
    @Test
    public void testSearchAnimalByName() {
        Circus circus = new Circus();
        circus.addAnimal(new Bird("Rio", 2, "Parrot", "Green", "bird.jpg"));
        circus.addAnimal(new Lion("Leo", 6, "Lion", "Brown", "lion.jpg"));

        assertNotNull(circus.searchAnimalByName("Rio"));
        assertNotNull(circus.searchAnimalByName("Leo"));
        assertNull(circus.searchAnimalByName("Missing"));
    }

    /*
     * Tests sorting animals by age.
     */
    @Test
    public void testSortAnimalsByAge() {
        Circus circus = new Circus();
        circus.addAnimal(new Lion("Leo", 6, "Lion", "Brown", "lion.jpg"));
        circus.addAnimal(new Bird("Rio", 2, "Parrot", "Green", "bird.jpg"));

        circus.sortAnimalsByAge();

        assertEquals("Rio", circus.getAnimals().get(0).getName());
        assertEquals("Leo", circus.getAnimals().get(1).getName());
    }

    /*
     * Tests sorting animals by name.
     */
    @Test
    public void testSortAnimalsByName() {
        Circus circus = new Circus();
        circus.addAnimal(new Lion("Leo", 6, "Lion", "Brown", "lion.jpg"));
        circus.addAnimal(new Bird("Rio", 2, "Parrot", "Green", "bird.jpg"));

        circus.sortAnimalsByName();

        assertEquals("Leo", circus.getAnimals().get(0).getName());
        assertEquals("Rio", circus.getAnimals().get(1).getName());
    }

    /*
     * Tests ticket generation.
     */
    @Test
    public void testGenerateTicket() {
        Circus circus = new Circus();
        String details = circus.generateTicket("Monday", 20.0, "Upper Level", 0.10, 2);

        assertTrue(details.contains("Day: Monday"));
        assertTrue(details.contains("Seat Level: Upper Level"));
        assertTrue(details.contains("Total Price"));
    }
}