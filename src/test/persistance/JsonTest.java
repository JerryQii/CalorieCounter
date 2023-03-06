package persistance;

import model.Food;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkFood(String name, String unit, double amount, double calorie, Food food) {
        assertEquals(name, food.getName());
        assertEquals(unit, food.getUnit());
        assertEquals(amount, food.getAmount());
        assertEquals(calorie, food.getCalorie());
    }
}
