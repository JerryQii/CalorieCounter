package persistence;

import model.Food;
import model.ListOfFood;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;


    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of food from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfFood read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfFood(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses list of food from JSON object and returns it
    private ListOfFood parseListOfFood(JSONObject jsonObject) {
        //String name = jsonObject.getString("name");
        ListOfFood lof = new ListOfFood();
        addFoods(lof, jsonObject);
        return lof;
    }

    // MODIFIES: lof
    // EFFECTS: parses food from JSON object and adds them to list of food
    private void addFoods(ListOfFood lof, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ListOfFood");
        for (Object json : jsonArray) {
            JSONObject nextFood = (JSONObject) json;
            addFood(lof, nextFood);
        }
    }

    // MODIFIES: lof
    // EFFECTS: parses food from JSON object and adds it to list of food
    private void addFood(ListOfFood lof, JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        double amount = jsonObject.getDouble("amount");
        String name = jsonObject.getString("name");
        String unit = jsonObject.getString("unit");
        double calorie = jsonObject.getDouble("calorie");
        //Category category = Category.valueOf(jsonObject.getString("category"));
        Food food = new Food(name, unit, calorie, id);
        Food food2 = new Food(food, amount, id);
        lof.addFood(food2);
    }
}
