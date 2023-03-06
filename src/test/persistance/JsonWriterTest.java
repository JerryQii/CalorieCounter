package persistance;

import model.Food;
import model.ListOfFood;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterIllegalFileError() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json", "./data/my\0illegal:fileName2.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {

        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            ListOfFood lofc = new ListOfFood();
            ListOfFood lofe = new ListOfFood();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom1.json", "./data/testWriterEmptyWorkroom2.json");
            writer.open();
            writer.write(lofc,lofe);
            writer.close();

            JsonReader readerc = new JsonReader("./data/testWriterEmptyWorkroom1.json");
            JsonReader readere = new JsonReader("./data/testWriterEmptyWorkroom2.json");
            lofc = readerc.read();
            lofe = readere.read();
            assertEquals(0, lofc.getList().size());
            assertEquals(0, lofe.getList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            ListOfFood lofc = new ListOfFood();
            ListOfFood lofe = new ListOfFood();
            Food ramen = new Food("ramen", "bowl", 550);
            Food pizza = new Food("pizza", "slice", 285);
            Food rameneaten = new Food(ramen,2);
            Food pizzaeaten = new Food(pizza,3);
            lofc.addFood(ramen);
            lofc.addFood(pizza);
            lofe.addFood(pizzaeaten);
            lofe.addFood(rameneaten);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroomC.json","./data/testWriterGeneralWorkroomE.json");
            writer.open();
            writer.write(lofc,lofe);
            writer.close();

            JsonReader readerC = new JsonReader("./data/testWriterGeneralWorkroomC.json");
            JsonReader readerE = new JsonReader("./data/testWriterGeneralWorkroomE.json");
            lofc = readerC.read();
            lofe = readerE.read();
            List<Food> foodsC = lofc.getList();
            List<Food> foodsE = lofe.getList();
            assertEquals(2, foodsC.size());
            checkFood("ramen", "bowl",0, 550, foodsC.get(0));
            checkFood("pizza", "slice", 0, 285, foodsC.get(1));
            checkFood("ramen", "bowl",2, 550, foodsE.get(1));
            checkFood("pizza", "slice", 3, 285, foodsE.get(0));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
