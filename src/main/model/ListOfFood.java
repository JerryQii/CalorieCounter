package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of food with all available elements to be added to list of food intake
public class ListOfFood {
    private List<Food> lof;

    // EFFECTS: construct a list of food available
    public ListOfFood() {
        lof = new ArrayList<>();
    }

    // EFFECTS: return the list of food available
    public List<Food> getLof() {
        return this.lof;
    }

    public Food getElement(int i) {
        return lof.get(i);
    }

    // MODIFIES: this
    // EFFECTS: add the given food to the list of food available
    public void addFood(Food food) {
        lof.add(food);
    }

    public void printList() {
        for (Food food : lof) {
            System.out.println(food.printFood());
        }
    }

    public void printListEaten() {
        for (Food food : lof) {
            System.out.println(food.printFoodEaten());
        }
    }
}
