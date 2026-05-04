/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Stores the discount rate for each day of the week.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public enum DayOfWeek {
    MONDAY(0.10),
    TUESDAY(0.10),
    WEDNESDAY(0.10),
    THURSDAY(0.10),
    FRIDAY(0.10),
    SATURDAY(0.0),
    SUNDAY(0.0);

    private final double discount;

    /*
     * Constructor
     * Each enum value stores its own discount amount.
     */
    DayOfWeek(double discount) {
        this.discount = discount;
    }

    /*
     * getDiscount
     * Returns the discount rate for the selected day.
     */
    public double getDiscount() {
        return discount;
    }
}