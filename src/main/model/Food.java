package model;

// Represents a kind of food with its name, unit, and calorie per unit.
public class Food {
    private static int unifoodid = 0;
    private int id;
    private double amount;
    private String name;
    private String unit;
    private double calorie;

    /*
     * REQUIRES: length of foodname and foodunit is non-zero,
     *           calorie >= 0
     * EFFECTS: construct a food choice with given name,
     *          unit, calorie and label it with food id.
     */
    public Food(String foodname, String foodunit, double calorie) {
        this.id = unifoodid++;
        this.amount = 0;
        this.name = foodname;
        this.unit = foodunit;
        this.calorie = calorie;
    }

    /*
     * REQUIRES: food matches the requirement above
     *           double >= 0
     * EFFECTS: construct a eaten food with given name,
     *          unit, calorie, amount and label it with food id.
     */
    public Food(Food food, double amount) {
        this.id = unifoodid++;
        this.amount = amount;
        this.name = food.name;
        this.unit = food.unit;
        this.calorie = food.calorie;
    }

    // EFFECTS: return the id of food
    public int getId() {
        return this.id;
    }

    // EFFECTS: return the name of food
    public String getName() {
        return this.name;
    }

    // EFFECTS: return the unit of food
    public String getUnit() {
        return this.unit;
    }

    // EFFECTS: return the calorie of food
    public double getCalorie() {
        return this.calorie;
    }

    //EFFECTS: return the amount of food
    public double getAmount() {
        return this.amount;
    }

    // EFFECTS: print the food with id, name, unit, and calorie
    public String printFood() {
        return "   FoodID:" + String.valueOf(id) + "  Name:" + name + "  Unit:" + unit + "  Calorie:" + calorie;
    }

    // EFFECTS: print the food with id, name, unit, calorie, and amount
    public String printFoodEaten() {
        return "   FoodID:" + String.valueOf(id) + "  Name:" + name + "  Unit:" + unit + "  Calorie:" + calorie
                + "  Amount:" + amount;
    }
}
