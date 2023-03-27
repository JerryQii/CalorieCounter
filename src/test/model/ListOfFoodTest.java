package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ListOfFoodTest {
    private Food ramen = new Food("ramen", "bowl", 550, 1);
    private Food pizza = new Food("pizza", "slice", 225, 2);
    private Food rameneaten = new Food(ramen,1.5,3);
    private ListOfFood listchoice;
    private ListOfFood listfoodeaten;
    private ListOfFood randomlist;

    @BeforeEach
    public void runBefore() {
        listchoice = new ListOfFood();
        listfoodeaten = new ListOfFood();
        randomlist = new ListOfFood();
        listchoice.addFood(ramen);
        listchoice.addFood(pizza);
        listfoodeaten.addFood(rameneaten);
        randomlist.addFood(pizza);
        randomlist.addFood(ramen);
    }

    @Test
    public void addFoodTest() {
        assertEquals(2,listchoice.getList().size());
    }

    @Test
    public void getElementTest() {
        assertEquals(ramen, listchoice.getFood(ramen.getId()));
        assertNull(listchoice.getFood(7));
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
        listchoice.deleteFood(3);
        assertEquals(2, listchoice.getList().size());
    }

    @Test
    void rearrangeTest() {
        randomlist.rearrange();
        assertEquals(pizza,randomlist.getFood(1));
    }
}
