/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: JavaFX driver application for Bob's Circus. Supports adding, displaying, sorting, searching, and ticket generation.
 * Due: 05/04/2026
 * Platform/compiler: Eclipse / JavaFX
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircusDriverApp_GUI extends Application {

    private Circus circus = new Circus();
    private VBox animalListBox;
    private TextArea outputArea;

    /*
     * main
     * Starts the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * start
     * Builds the main GUI window and connects all button actions.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Bob's Circus Management System");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(770);
        outputArea.setText("Bob's Circus Management System\nProgrammer: William Binder");

        Button addAnimalBtn = new Button("Add Animal");
        Button addPersonBtn = new Button("Add Person");
        Button addBuildingBtn = new Button("Add Building");
        Button ticketBtn = new Button("Generate Ticket");
        Button displayAnimalsBtn = new Button("Display All Animals");
        Button displayPersonsBtn = new Button("Display All Persons");
        Button displayBuildingsBtn = new Button("Display All Buildings");
        Button sortAgeBtn = new Button("Sort Animals by Age");
        Button sortNameBtn = new Button("Sort Animals by Name");
        Button searchBtn = new Button("Search Animal by Name");
        Button exitBtn = new Button("Exit");

        FlowPane menu = new FlowPane(10, 10,
                addAnimalBtn, addPersonBtn, addBuildingBtn, ticketBtn,
                displayAnimalsBtn, displayPersonsBtn, displayBuildingsBtn,
                sortAgeBtn, sortNameBtn, searchBtn, exitBtn
        );
        menu.setAlignment(Pos.CENTER);

        VBox leftPanel = new VBox(10, menu, outputArea);
        leftPanel.setPrefWidth(600);

        animalListBox = new VBox(8);
        animalListBox.setPadding(new Insets(10));

        ScrollPane animalScrollPane = new ScrollPane(animalListBox);
        animalScrollPane.setFitToWidth(true);
        animalScrollPane.setPrefHeight(800);

        VBox animalPanel = new VBox(8, new Label("Image + Details"), animalScrollPane);
        animalPanel.setPrefHeight(850);
        animalPanel.setPadding(new Insets(10));
        animalPanel.setStyle("-fx-border-color: gray;");

        HBox root = new HBox(15, leftPanel, animalPanel);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 900, 650));
        stage.show();

        addAnimalBtn.setOnAction(e -> handleAddAnimal());
        addPersonBtn.setOnAction(e -> handleAddPerson());
        addBuildingBtn.setOnAction(e -> handleAddBuilding());
        ticketBtn.setOnAction(e -> handleGenerateTicket());

        displayAnimalsBtn.setOnAction(e -> {
            displayAnimalsWithImages();
            outputArea.setText(captureConsole(() -> circus.displayAllAnimals()));
        });

        displayPersonsBtn.setOnAction(e -> {
            displayPersonsWithImages();
            outputArea.setText(captureConsole(() -> circus.displayAllPersons()));
        });

        displayBuildingsBtn.setOnAction(e -> {
            displayBuildingsWithImages();
            outputArea.setText(captureConsole(() -> circus.displayAllBuildings()));
        });

        sortAgeBtn.setOnAction(e -> {
            circus.sortAnimalsByAge();
            displayAnimalsWithImages();
            outputArea.setText("Animals sorted by age.\nProgrammer: William Binder");
        });

        sortNameBtn.setOnAction(e -> {
            circus.sortAnimalsByName();
            displayAnimalsWithImages();
            outputArea.setText("Animals sorted by name.\nProgrammer: William Binder");
        });

        searchBtn.setOnAction(e -> handleSearchAnimal());
        exitBtn.setOnAction(e -> stage.close());
    }

    /*
     * handleGenerateTicket
     * Repeats ticket entry until the user answers n, then prints final ticket details.
     */
    private void handleGenerateTicket() {
        animalListBox.getChildren().clear();

        StringBuilder allDetails = new StringBuilder();
        allDetails.append("Ticket Calculation Details:\n");

        boolean moreTickets = true;

        while (moreTickets) {
            List<String> dayChoices = new ArrayList<>();
            for (DayOfWeek d : DayOfWeek.values()) {
                int pct = (int) (d.getDiscount() * 100);
                dayChoices.add(d.name().charAt(0) + d.name().substring(1).toLowerCase()
                        + " (" + pct + "% discount)");
            }

            ChoiceDialog<String> dayDialog = new ChoiceDialog<>(dayChoices.get(0), dayChoices);
            dayDialog.setHeaderText("Select Day of Week");
            Optional<String> dayOpt = dayDialog.showAndWait();
            if (dayOpt.isEmpty()) {
                break;
            }
            String day = dayOpt.get().split(" ")[0];

            List<String> customerChoices = List.of(
                    "Child (10% discount)",
                    "Student (10% discount)",
                    "Adult",
                    "Senior (5% discount)"
            );

            ChoiceDialog<String> customerDialog = new ChoiceDialog<>(customerChoices.get(0), customerChoices);
            customerDialog.setHeaderText("Select Customer Type");
            Optional<String> customerOpt = customerDialog.showAndWait();
            if (customerOpt.isEmpty()) {
                break;
            }

            String customerType = customerOpt.get();
            double customerDiscount = 0.0;

            // Child and Student get 10 percent off. Senior gets 5 percent off.
            if (customerType.startsWith("Child") || customerType.startsWith("Student")) {
                customerDiscount = 0.10;
            } else if (customerType.startsWith("Senior")) {
                customerDiscount = 0.05;
            }

            List<String> seatChoices = List.of("Lower Level", "T-Level", "Upper Level");
            ChoiceDialog<String> seatDialog = new ChoiceDialog<>(seatChoices.get(0), seatChoices);
            seatDialog.setHeaderText("Select Seat Level");
            Optional<String> seatOpt = seatDialog.showAndWait();
            if (seatOpt.isEmpty()) {
                break;
            }

            String seatLevel = seatOpt.get();
            double basePrice = inputDouble("Enter base price:");
            int ticketCount = inputInt("Enter number of tickets:");

            String details = circus.generateTicket(day, basePrice, seatLevel, customerDiscount, ticketCount);
            allDetails.append(details).append("\n");

            TextInputDialog moreDialog = new TextInputDialog();
            moreDialog.setHeaderText("Do you want to add more tickets? (y/n):");
            Optional<String> moreOpt = moreDialog.showAndWait();

            if (moreOpt.isPresent()) {
                moreTickets = moreOpt.get().trim().equalsIgnoreCase("y");
            } else {
                moreTickets = false;
            }
        }

        allDetails.append("Programmer: William Binder");
        outputArea.setText(allDetails.toString());
    }

    /*
     * handleAddAnimal
     * Collects animal information from dialogs and adds the selected animal type.
     */
    private void handleAddAnimal() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Dog", "Dog", "Horse", "Bird", "Lion");
        dialog.setHeaderText("Select Animal Type");
        Optional<String> type = dialog.showAndWait();
        if (type.isEmpty()) {
            return;
        }

        String name = inputText("Enter name:");
        int age = inputInt("Enter age:");
        String species = inputText("Enter species:");
        String color = inputText("Enter color:");
        String imagePath = inputText("Enter image file path:");

        Animal animal = null;

        if (type.get().equals("Dog")) {
            animal = new Dog(name, age, species, color, imagePath);
        } else if (type.get().equals("Horse")) {
            animal = new Horse(name, age, species, color, imagePath);
        } else if (type.get().equals("Bird")) {
            animal = new Bird(name, age, species, color, imagePath);
        } else if (type.get().equals("Lion")) {
            animal = new Lion(name, age, species, color, imagePath);
        }

        if (animal != null) {
            circus.addAnimal(animal);
            outputArea.setText("Animal added successfully.\nProgrammer: William Binder");
        }
    }

    /*
     * handleAddPerson
     * Collects person information and adds either a Clerk or Acrobatic object.
     */
    private void handleAddPerson() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Clerk", "Clerk", "Acrobatic");
        dialog.setHeaderText("Select Person Type");
        Optional<String> type = dialog.showAndWait();
        if (type.isEmpty()) {
            return;
        }

        String name = inputText("Enter name:");
        int age = inputInt("Enter age:");
        int yearsWorked = inputInt("Enter years worked:");
        String job = inputText("Enter job:");
        String imagePath = inputText("Enter image file path:");

        Person person;

        if (type.get().equals("Clerk")) {
            person = new Clerk(name, age, yearsWorked, job, imagePath);
        } else {
            person = new Acrobatic(name, age, yearsWorked, job, imagePath);
        }

        circus.addPerson(person);
        outputArea.setText("Person added successfully.\nProgrammer: William Binder");
    }

    /*
     * handleAddBuilding
     * Collects building information and adds either an Arena or TicketingOffice object.
     */
    private void handleAddBuilding() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Arena", "Arena", "Ticketing Office");
        dialog.setHeaderText("Select Building Type");
        Optional<String> type = dialog.showAndWait();
        if (type.isEmpty()) {
            return;
        }

        String color = inputText("Enter color:");
        double length = inputDouble("Enter length:");
        double width = inputDouble("Enter width:");
        String imagePath = inputText("Enter image file path:");

        Building building;

        if (type.get().equals("Arena")) {
            building = new Arena(color, length, width, imagePath);
        } else {
            building = new TicketingOffice(color, length, width, imagePath);
        }

        circus.addBuilding(building);
        outputArea.setText("Building added successfully.\nProgrammer: William Binder");
    }

    /*
     * displayAnimalsWithImages
     * Shows animal text and image cards on the right side of the GUI.
     */
    private void displayAnimalsWithImages() {
        animalListBox.getChildren().clear();

        for (Animal animal : circus.getAnimals()) {
            VBox box = new VBox(5);
            box.getChildren().add(new Label(animal.toString()));

            try {
                // Load the image only if the path is not blank.
                if (animal.getImagePath() != null && !animal.getImagePath().isBlank()) {
                    Image image = new Image("file:" + animal.getImagePath(), 120, 90, true, true);
                    ImageView iv = new ImageView(image);
                    box.getChildren().add(iv);
                }
            } catch (Exception e) {
                box.getChildren().add(new Label("(Image could not be loaded)"));
            }

            box.setStyle("-fx-border-color: lightgray; -fx-padding: 8;");
            animalListBox.getChildren().add(box);
        }
    }

    /*
     * displayPersonsWithImages
     * Shows person text and image cards on the right side of the GUI.
     */
    private void displayPersonsWithImages() {
        animalListBox.getChildren().clear();

        for (Person person : circus.getPersons()) {
            VBox box = new VBox(5);
            box.getChildren().add(new Label(person.toString()));

            try {
                if (person.getImagePath() != null && !person.getImagePath().isBlank()) {
                    Image image = new Image("file:" + person.getImagePath(), 120, 90, true, true);
                    ImageView iv = new ImageView(image);
                    box.getChildren().add(iv);
                }
            } catch (Exception e) {
                box.getChildren().add(new Label("(Image could not be loaded)"));
            }

            box.setStyle("-fx-border-color: lightgray; -fx-padding: 8;");
            animalListBox.getChildren().add(box);
        }
    }

    /*
     * displayBuildingsWithImages
     * Shows building text and image cards on the right side of the GUI.
     */
    private void displayBuildingsWithImages() {
        animalListBox.getChildren().clear();

        for (Building building : circus.getBuildings()) {
            VBox box = new VBox(5);
            box.getChildren().add(new Label(building.toString()));

            try {
                if (building.getImagePath() != null && !building.getImagePath().isBlank()) {
                    Image image = new Image("file:" + building.getImagePath(), 120, 90, true, true);
                    ImageView iv = new ImageView(image);
                    box.getChildren().add(iv);
                }
            } catch (Exception e) {
                box.getChildren().add(new Label("(Image could not be loaded)"));
            }

            box.setStyle("-fx-border-color: lightgray; -fx-padding: 8;");
            animalListBox.getChildren().add(box);
        }
    }

    /*
     * handleSearchAnimal
     * Searches by name and prints either the matching animal or a not found message.
     */
    private void handleSearchAnimal() {
        String name = inputText("Enter animal name to search:");
        Animal animal = circus.searchAnimalByName(name);

        if (animal == null) {
            outputArea.setText("Animal not found.\nProgrammer: William Binder");
        } else {
            outputArea.setText("Found:\n" + animal.toString() + "\nProgrammer: William Binder");
        }
    }

    /*
     * inputText
     * Displays a dialog and returns the entered text, or an empty string if cancelled.
     */
    private String inputText(String prompt) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText(prompt);
        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }

    /*
     * inputInt
     * Repeats until the user enters a valid integer.
     */
    private int inputInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(inputText(prompt));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid integer.");
                alert.showAndWait();
            }
        }
    }

    /*
     * inputDouble
     * Repeats until the user enters a valid decimal number.
     */
    private double inputDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(inputText(prompt));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number.");
                alert.showAndWait();
            }
        }
    }

    /*
     * captureConsole
     * Redirects console output into a string so it can be displayed inside the GUI text area.
     */
    private String captureConsole(Runnable action) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        action.run();
        System.setOut(oldOut);
        return baos.toString();
    }
}