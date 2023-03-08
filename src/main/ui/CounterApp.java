package ui;

import model.Food;
import model.ListOfFood;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Calorie counter application
public class CounterApp {
    private ListOfFood lofc = new ListOfFood();
    private ListOfFood lofe = new ListOfFood();
    private Scanner command = new Scanner(System.in);
    private static final String JSON_STORE_c = "./data/ListOfFoodChoice.json";
    private static final String JSON_STORE_e = "./data/ListOfFoodEaten.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReaderC;
    private JsonReader jsonReaderE;


    // EFFECTS: run the calorie counter application
    public CounterApp() {
        runcounterapp();
    }

    // MODIFIES: this
    // EFFECTS: works according to user input
    private void runcounterapp() {
        boolean running = true;
        String input = null;
        jsonWriter = new JsonWriter(JSON_STORE_c, JSON_STORE_e);
        jsonReaderC = new JsonReader(JSON_STORE_c);
        jsonReaderE = new JsonReader(JSON_STORE_e);

        //initialize();
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

    // EFFECTS: print the start menu for user
    private void printStartMenu() {
        System.out.println("Please press the following buttons to proceed");
        System.out.println("   >a : add the food you eat from list of food choice");
        System.out.println("   >b : add new food choice to list of food choice");
        System.out.println("   >c : delete the food you eat from list of food eaten");
        System.out.println("   >d : delete food choice in list of food choice");
        System.out.println("   >e : calculate the total calorie");
        System.out.println("   >f : save the list of food choices and food eaten");
        System.out.println("   >g : load the list of food choices and food eaten");
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
        } else if (input.equals("f")) {
            savelist();
        } else if (input.equals("g")) {
            loadlist();
        } else {
            System.out.println("invalid command!");
        }
    }


    private void savelist() {
        try {
            jsonWriter.open();
            jsonWriter.write(lofc, lofe);
            jsonWriter.close();
            System.out.println("Saved list of food choices to " + JSON_STORE_c);
            System.out.println("Saved list of food eaten to " + JSON_STORE_e);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE_c + "or" + JSON_STORE_e);
        }
    }

    private void loadlist() {
        try {
            lofc = jsonReaderC.read();
            lofe = jsonReaderE.read();
            System.out.println("Loaded list of food choices from " + JSON_STORE_c);
            System.out.println("Loaded list of food eaten from " + JSON_STORE_e);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE_c + "or" + JSON_STORE_e);
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: add user's eaten food from list of food choice
     */
    private void addEatenFood() {
        System.out.println("Please enter the id of food below that you want to add");
        for (Food food : lofc.getList()) {
            System.out.println(food.printFood());
        }
        int inputId = command.nextInt();
        System.out.println("Please enter the number of units that you ate");
        double inputAmount = command.nextDouble();
        System.out.println("Please enter the new different id for the food you eat");
        int inputid = command.nextInt();
        Food newfood = new Food(lofc.getFood(inputId), inputAmount,inputid);
        lofe.addFood(newfood);
        System.out.println("And below is your list of food eaten!");
        for (Food food : lofe.getList()) {
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
        System.out.println("Please enter the new different id for the food choice");
        int inputid = command.nextInt();
        Food addedfood = new Food(name,unit,calorie, inputid);
        lofc.addFood(addedfood);
        System.out.println("Below is your new list of food choice");
        for (Food food : lofc.getList()) {
            System.out.println(food.printFood());
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: delete food choice in the list of food choice
     */
    private void deleteFoodChoice() {
        System.out.println("Below is your list of food choice!");
        for (Food food : lofc.getList()) {
            System.out.println(food.printFood());
        }
        System.out.println("What's the id of the food choice you want to delete");
        int id = command.nextInt();
        lofc.deleteFood(id);
        System.out.println("Below is your new list of food choice!");
        for (Food food : lofc.getList()) {
            System.out.println(food.printFood());
        }

    }

    /*
     * MODIFIES: this
     * EFFECTS: delete user's eaten food in the list of food eaten
     */
    private void deleteEatenFood() {
        System.out.println("Below is your list of food eaten!");
        for (Food food : lofe.getList()) {
            System.out.println(food.printFoodEaten());
        }
        System.out.println("What's the id of the food eaten you want to delete");
        int id = command.nextInt();
        lofe.deleteFood(id);
        System.out.println("Below is your new list of food choice!");
        for (Food food : lofe.getList()) {
            System.out.println(food.printFoodEaten());
        }
    }

    // EFFECTS: print the total calorie of the list of food eaten
    private void calculateCalorie() {
        System.out.println("Here's the list of food you've eaten");
        for (Food food : lofe.getList()) {
            System.out.println(food.printFoodEaten());
        }
        System.out.println("And the total calorie is " + lofe.totalCalorie() + " calories!");
    }
}
