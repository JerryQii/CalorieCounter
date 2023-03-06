package persistance;

import model.Food;
import model.ListOfFood;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfFood lof = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom1.json");
        try {
            ListOfFood lof = reader.read();
            assertEquals(0, lof.getList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroomC.json");
        try {
            ListOfFood lof = reader.read();
            List<Food> foodsC = lof.getList();
            assertEquals(2, foodsC.size());
            checkFood("ramen", "bowl",0, 550, foodsC.get(0));
            checkFood("pizza", "slice", 0, 285, foodsC.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
