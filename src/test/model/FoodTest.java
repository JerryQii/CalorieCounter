package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {
    Food pizza2 = new Food("pizza2", "slice", 225);
    Food pizza3 = new Food("pizza2", "slice", 225);

    //@BeforeEach
    ListOfFood list1 = new ListOfFood();

    @Test
    public void printTest() {
        list1.addFood(pizza2);
        list1.addFood(pizza3);
        list1.printList();
        //String result = list1.print();
        //assertEquals("test", result);
    }

}