package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// Represents a list of food with all available elements to be added to list of food intake
public class ListOfFood {
    private List<Food> lof;

    // EFFECTS: construct a list of food available
    public ListOfFood() {
        lof = new ArrayList<>();
    }

    // EFFECTS: return the food with id equals to i in the list
    public Food getFood(int i) {
        for (Food food: lof) {
            if (food.getId() == i) {
                return food;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: add the given food to the list of food available
    public void addFood(Food food) {
        lof.add(food);
    }

    // EFFECTS: return lof
    public List<Food> getList() {
        return lof;
    }

    // EFFECTS: return the total calorie of all the eaten food with amount in the list
    public double totalCalorie() {
        double calorie = 0;
        for (Food food:lof) {
            calorie += food.getCalorie() * food.getAmount();
        }
        return calorie;
    }

    // MODIFIES: this
    // EFFECTS: delete the i-th element in the list
    public void deleteFood(int id) {
        int index = -1;
        int trueid = -1;
        for (Food food:lof) {
            if (food.getId() == id) {
                trueid = index + 1;
            } else {
                index += 1;
            }
        }
        if (!(trueid == -1)) {
            lof.remove(trueid);
        }
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("ListOfFood", loftoJson());
        return json;
    }

    // EFFECTS: returns list of food as JSON array
    public JSONArray loftoJson() {
        JSONArray jsonArray = new JSONArray();

        for (Food f : lof) {
            jsonArray.put(f.toJson());
        }

        return jsonArray;
    }

}
