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
     * EFFECTS: construct a kind of food with given name,
     *          unit, calorie and label it with food id.
     */
    public Food(String foodname, String foodunit, double calorie) {
        this.id = unifoodid++;
        this.amount = 0;
        this.name = foodname;
        this.unit = foodunit;
        this.calorie = calorie;
    }

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

    /*
     * REQUIRES: amount>0
     * MODIFIES: this
     * EFFECTS: set the amount of food to given double
     */
    public Food setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    /*
     * MODIFIES: this
     * EFFECTS: decrease unifoodid by 1
     */
    public void decreaseID() {
        this.unifoodid--;
    }

    public String printFood() {
        return "   FoodID:" + String.valueOf(id) + "  Name:" + name + "  Unit:" + unit + "  Calorie:" + calorie;
    }

    public String printFoodEaten() {
        return "   FoodID:" + String.valueOf(id) + "  Name:" + name + "  Unit:" + unit + "  Calorie:" + calorie
                + "  Amount:" + amount;
    }
}
