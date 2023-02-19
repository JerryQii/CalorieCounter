package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of food with all available elements to be added to list of food intake
public class ListOfFoodAvailable {
    private List<Food> lofa;

    // EFFECTS: construct a list of food available
    public ListOfFoodAvailable() {
        lofa = new ArrayList<>();
    }

    // EFFECTS: return the list of food available
    public List<Food> getLofa() {
        return this.lofa;
    }

    // MODIFIES: this
    // EFFECTS: add the given food to the list of food available
    public void addFood(Food food) {
        lofa.add(food);
    }
}
