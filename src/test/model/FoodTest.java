package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FoodTest {
    private Food ramen;
    private Food pizza;
    private Food rameneaten;


    @BeforeEach
    public void runBefore() {
        ramen = new Food("ramen", "bowl", 550, 1);
        pizza = new Food("pizza", "slice", 225, 2);
        rameneaten = new Food(ramen,1.5,3);
    }



    @Test
    public void FirstFoodTest() {
        assertEquals("pizza", pizza.getName());
        assertEquals("slice", pizza.getUnit());
        assertTrue(pizza.getId()==2);
        assertTrue(ramen.getId()==1);
        assertEquals(550, ramen.getCalorie());
        assertEquals(0, ramen.getAmount());
    }

    @Test
    public void SecondFoodTest() {
        assertEquals("ramen", rameneaten.getName());
        assertEquals("bowl", rameneaten.getUnit());
        assertTrue(rameneaten.getId()==3);
        assertEquals(550, rameneaten.getCalorie());
        assertEquals(1.5, rameneaten.getAmount());
    }

    @Test
    public void printFoodTest() {
        assertEquals("   FoodID:2  Name:pizza  Unit:slice  Calorie:225.0",pizza.printFood());
        assertEquals("   FoodID:3  Name:ramen  Unit:bowl  Calorie:550.0  Amount:1.5",rameneaten.printFoodEaten());
    }


}