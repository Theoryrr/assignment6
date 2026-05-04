/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents the circus arena. Implements the Building interface.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class Arena implements Building {
    private String color;
    private double length;
    private double width;
    private String buildingType;
    private String imagePath;

    /*
     * Constructor
     * Stores building information and sets the default type to Arena.
     */
    public Arena(String color, double length, double width, String imagePath) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Arena";
        this.imagePath = imagePath;
    }

    /*
     * setSize
     * Updates both length and width together.
     */
    @Override
    public void setSize(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /*
     * getLength
     * Returns the arena length.
     */
    @Override
    public double getLength() {
        return length;
    }

    /*
     * getWidth
     * Returns the arena width.
     */
    @Override
    public double getWidth() {
        return width;
    }

    /*
     * setColor
     * Updates the arena color.
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    /*
     * getColor
     * Returns the arena color.
     */
    @Override
    public String getColor() {
        return color;
    }

    /*
     * setBuildingType
     * Allows the building type text to be changed if needed.
     */
    @Override
    public void setBuildingType(String type) {
        buildingType = type;
    }

    /*
     * getBuildingType
     * Returns the building type text.
     */
    @Override
    public String getBuildingType() {
        return buildingType;
    }

    /*
     * getImagePath
     * Returns the image path used in the GUI.
     */
    @Override
    public String getImagePath() {
        return imagePath;
    }

    /*
     * toString
     * Returns a readable description of the arena.
     */
    @Override
    public String toString() {
        return String.format("Building Type: %s%nColor: %s%nSize: %.1f x %.1f%nImage: %s%n",
                buildingType, color, length, width, imagePath);
    }
}