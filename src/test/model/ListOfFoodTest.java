package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ListOfFoodTest {
    private Food ramen = new Food("ramen", "bowl", 550);
    private Food pizza = new Food("pizza", "slice", 225);
    private Food rameneaten = new Food(ramen,1.5);
    private ListOfFood listchoice;
    private ListOfFood listfoodeaten;

    @BeforeEach
    public void runBefore() {
        listchoice = new ListOfFood();
        listfoodeaten = new ListOfFood();
        listchoice.addFood(ramen);
        listchoice.addFood(pizza);
        listfoodeaten.addFood(rameneaten);
    }

    @Test
    public void addFoodTest() {
        assertEquals(2,listchoice.getList().size());
    }

    @Test
    public void getElementTest() {
        assertEquals(ramen, listchoice.getFood(ramen.getId()));
        assertNull(listchoice.getFood(2));
    }

    @Test
    public void totalCalorieTest() {
        assertEquals(825,listfoodeaten.totalCalorie());
    }

    @Test
    public void deleteTest() {
        listchoice.deleteFood(ramen.getId());
        assertEquals(1, listchoice.getList().size());
    }

    @Test
    public void deleteFailedTest() {
        listchoice.deleteFood(2);
        assertEquals(2, listchoice.getList().size());
    }
}
