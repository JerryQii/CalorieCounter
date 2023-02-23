package ui;

import model.Food;
import model.ListOfFood;

import java.util.Scanner;

//Calorie counter application
public class CounterApp {
    private ListOfFood lofa = new ListOfFood();
    private ListOfFood lofi = new ListOfFood();
    private Scanner command = new Scanner(System.in);
    private double dailycalorie;

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
        System.out.println("Hi! Welcome to use this application! ");
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

    // EFFECTS: print the start menu for user
    private void printStartMenu() {
        System.out.println("Please press the following buttons to proceed");
        System.out.println("   >a : add the food you eat from list of food choice");
        System.out.println("   >b : add new food choice to list of food choice");
        System.out.println("   >c : delete the food you eat from list of food eaten");
        System.out.println("   >d : delete food choice in list of food choice");
        System.out.println("   >e : calculate the total calorie");
        System.out.println("   >q : quit this application");
    }

    /*
     * MODIFIES: this
     * EFFECTS: deal with user input from start menu
     */
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

    /*
     * MODIFIES: this
     * EFFECTS: add user's eaten food from list of food choice
     */
    private void addEatenFood() {
        System.out.println("Please enter the id of food below that you want to add");
        for (Food food : lofa.getList()) {
            System.out.println(food.printFood());
        }
        int inputId = command.nextInt();
        System.out.println("Please enter the number of units that you ate");
        double inputAmount = command.nextDouble();
        Food newfood = new Food(lofa.getFood(inputId), inputAmount);
        lofi.addFood(newfood);
        System.out.println("And below is your list of food eaten!");
        for (Food food : lofi.getList()) {
            System.out.println(food.printFoodEaten());
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: add new food choice to list of food choice
     */
    private void addFoodChoice() {
        System.out.println("What's the name of the food");
        String name = command.next();
        System.out.println("What's the unit of the food");
        String unit = command.next();
        System.out.println("What's the calorie per unit of the food");
        double calorie = command.nextDouble();
        Food addedfood = new Food(name,unit,calorie);
        lofa.addFood(addedfood);
        System.out.println("Below is your new list of food choice");
        for (Food food : lofa.getList()) {
            System.out.println(food.printFood());
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: delete food choice in the list of food choice
     */
    private void deleteFoodChoice() {
        System.out.println("Below is your list of food choice!");
        for (Food food : lofa.getList()) {
            System.out.println(food.printFood());
        }
        System.out.println("What's the id of the food choice you want to delete");
        int id = command.nextInt();
        lofa.deleteFood(id);
        System.out.println("Below is your new list of food choice!");
        for (Food food : lofa.getList()) {
            System.out.println(food.printFood());
        }

    }

    /*
     * MODIFIES: this
     * EFFECTS: delete user's eaten food in the list of food eaten
     */
    private void deleteEatenFood() {
        System.out.println("Below is your list of food eaten!");
        for (Food food : lofi.getList()) {
            System.out.println(food.printFoodEaten());
        }
        System.out.println("What's the id of the food eaten you want to delete");
        int id = command.nextInt();
        lofi.deleteFood(id);
        System.out.println("Below is your new list of food choice!");
        for (Food food : lofi.getList()) {
            System.out.println(food.printFoodEaten());
        }
    }

    // EFFECTS: print the total calorie of the list of food eaten
    private void calculateCalorie() {
        System.out.println("Here's the list of food you've eaten");
        for (Food food : lofi.getList()) {
            System.out.println(food.printFoodEaten());
        }
        System.out.println("And the total calorie is " + lofi.totalCalorie() + " calories!");
    }
}
