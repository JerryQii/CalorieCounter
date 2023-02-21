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
        System.out.println("   >a : add the food you eat from list of food choice");
        System.out.println("   >b : add new food choice to list of food choice");
        System.out.println("   >c : delete the food you eat from list of food eaten");
        System.out.println("   >d : delete food choice in list of food choice");
        System.out.println("   >e : calculate the total calorie");
        System.out.println("   >q : quit this application");
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
        System.out.println("And below is your list of food eaten!");
        lofi.printListEaten();
    }

    private void addFoodChoice() {
        System.out.println("What's the name of the food");
        String name = command.next();
        System.out.println("What's the unit of the food");
        String unit = command.next();
        System.out.println("What's the calorie per unit of the food");
        double calorie = command.nextDouble();
        Food addedfood = new Food(name,unit,calorie);
        lofa.addFood(addedfood);
    }

    private void deleteFoodChoice() {
        System.out.println("Below is your list of food choice!");
        lofa.printList();
        System.out.println("What's the id of the food choice you want to delete");
        int id = command.nextInt();
        lofa.deleteFood(id);
        System.out.println("Below is your new list of food choice!");
        lofa.printList();

    }

    private void deleteEatenFood() {
        System.out.println("Below is your list of food eaten!");
        lofi.printListEaten();
        System.out.println("What's the id of the food eaten you want to delete");
        int id = command.nextInt();
        lofi.deleteFood(id);
        System.out.println("Below is your new list of food choice!");
        lofi.printListEaten();
    }

    private void calculateCalorie() {
        System.out.println("Here's the list of food you've eaten");
        lofi.printListEaten();
        System.out.println("And the total calorie is " + lofi.totalCalorie() + " calories!");
    }
}
