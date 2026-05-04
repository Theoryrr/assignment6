/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Data manager class that stores animals, persons, buildings, and generated ticket details.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<String> tickets;

    /*
     * Constructor
     * Creates empty ArrayLists to store all circus data.
     */
    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    /*
     * addBuilding
     * Adds a building object to the building list.
     */
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    /*
     * displayAllBuildings
     * Prints every building in the list.
     */
    public void displayAllBuildings() {
        for (Building building : buildings) {
            System.out.println(building);
        }
    }

    /*
     * addPerson
     * Adds a person object to the person list.
     */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /*
     * displayAllPersons
     * Prints every person in the list.
     */
    public void displayAllPersons() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    /*
     * addAnimal
     * Adds an animal object to the animal list.
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /*
     * displayAllAnimals
     * Prints every animal in the list.
     */
    public void displayAllAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    /*
     * getAnimals
     * Returns the animal list so the GUI can show images and details.
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /*
     * getPersons
     * Returns the person list so the GUI can show images and details.
     */
    public List<Person> getPersons() {
        return persons;
    }

    /*
     * getBuildings
     * Returns the building list so the GUI can show images and details.
     */
    public List<Building> getBuildings() {
        return buildings;
    }

    /*
     * getTickets
     * Returns the stored ticket summaries.
     */
    public List<String> getTickets() {
        return tickets;
    }

    /*
     * sortAnimalsByAge
     * Uses selection sort to order animals from youngest to oldest.
     */
    public void sortAnimalsByAge() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
                    minIndex = j;
                }
            }

            // Swap the current item with the smallest age found.
            Animal temp = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, temp);
        }
    }

    /*
     * sortAnimalsByName
     * Uses selection sort to order animals alphabetically by name.
     */
    public void sortAnimalsByName() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getName().compareToIgnoreCase(animals.get(minIndex).getName()) < 0) {
                    minIndex = j;
                }
            }

            // Swap the current item with the alphabetically smallest name found.
            Animal temp = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, temp);
        }
    }

    /*
     * searchAnimalByName
     * Searches the animal list and returns the matching animal, or null if not found.
     */
    public Animal searchAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    /*
     * generateTicket
     * Calculates the final ticket price using seat level, day discount, customer discount,
     * and quantity. The ticket details are saved in the ticket list and returned as text.
     */
    public String generateTicket(String dayOfWeek, double basePrice, String seatLevel, double customerDiscount, int ticketCount) {
        double seatMultiplier = 1.0;

        // Seat levels change the base ticket price.
        if (seatLevel.equalsIgnoreCase("Lower Level")) {
            seatMultiplier = 1.50;
        } else if (seatLevel.equalsIgnoreCase("T-Level")) {
            seatMultiplier = 1.00;
        } else if (seatLevel.equalsIgnoreCase("Upper Level")) {
            seatMultiplier = 0.75;
        }

        DayOfWeek day = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
        double dayDiscount = day.getDiscount();

        // Apply seat pricing first, then weekday discount, then customer discount.
        double pricePerTicket = basePrice * seatMultiplier;
        pricePerTicket = pricePerTicket * (1 - dayDiscount);
        pricePerTicket = pricePerTicket * (1 - customerDiscount);

        double total = pricePerTicket * ticketCount;

        String details = "Day: " + dayOfWeek + "\n" +
                "Seat Level: " + seatLevel + "\n" +
                "Base Price: $" + String.format("%.2f", basePrice) + "\n" +
                "Price Per Ticket: $" + String.format("%.2f", pricePerTicket) + "\n" +
                "Ticket Count: " + ticketCount + "\n" +
                "Total Price: $" + String.format("%.2f", total) + "\n";

        tickets.add(details);
        return details;
    }
}