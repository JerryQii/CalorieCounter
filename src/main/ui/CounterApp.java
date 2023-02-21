package ui;

import model.Food;
import model.ListOfFood;

import java.util.Scanner;

//Calorie counter application
public class CounterApp {
    private ListOfFood lofa = new ListOfFood();
    private ListOfFood lofi = new ListOfFood();
    private Scanner command = new Scanner(System.in);

    // EFFECTS: run the calorie counter application
    public CounterApp() {
        runcounterapp();
    }

    // MODIFIES: this
    // EFFECTS: works according to user input
    private void runcounterapp() {
        boolean running = true;
        String input = null;

        initialize();
        while (running) {
            printStartMenu();
            input = command.next();
            if (input.equals("q")) {
                running = false;
            } else {
                dealInput(input);
            }
        }
        System.out.println("See you soon!");
    }

    /*
     * MODIFIES: this
     * EFFECTS: initializes lists of food available
     */
    private void initialize() {
        Food ramen = new Food("ramen", "bowl", 550);
        Food pizza = new Food("pizza", "slice", 285);
        Food coke = new Food("coke", "can", 185);
        lofa.addFood(ramen);
        lofa.addFood(pizza);
        lofa.addFood(coke);
    }

    private void printStartMenu() {
        System.out.println("Hi! Welcome to use this application! Please press the following buttons to proceed");
        System.out.println("   a : add the food you eat from list of food ");
        System.out.println("   b : add food choice to list of food");
        System.out.println("   c : delete the food you eat from list of food ");
        System.out.println("   d : delete food choice to list of food");
        System.out.println("   e : calculate the total calorie");
        System.out.println("   q : quit this application");
    }

    private void dealInput(String input) {
        if (input.equals("a")) {
            addEatenFood();
        } else if (input.equals("b")) {
            addFoodChoice();
        } else if (input.equals("c")) {
            deleteEatenFood();
        } else if (input.equals("d")) {
            deleteFoodChoice();
        } else if (input.equals("e")) {
            calculateCalorie();
        } else {
            System.out.println("invalid command!");
        }
    }

    private void addEatenFood() {
        System.out.println("Please enter the id of food below that you want to add");
        lofa.printList();
        int inputId = command.nextInt();
        System.out.println("Please enter the number of units that you ate");
        double inputCalorie = command.nextDouble();
        Food newfood = new Food(lofa.getElement(inputId), inputCalorie);
        lofi.addFood(newfood);
        System.out.println("Here is your list of eaten food!");
        lofi.printListEaten();
    }

    private void addFoodChoice() {

    }

    private void deleteFoodChoice() {

    }

    private void deleteEatenFood() {

    }

    private void calculateCalorie() {

    }
}
