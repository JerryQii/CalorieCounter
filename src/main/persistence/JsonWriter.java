package persistence;

import model.ListOfFood;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes JSON representation of list of food to file
public class JsonWriter {

    private static final int TAB = 4;
    private PrintWriter writerC;
    private PrintWriter writerE;
    private String destinationC;
    private String destinationE;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination1, String destination2) {
        this.destinationC = destination1;
        this.destinationE = destination2;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writerC = new PrintWriter(new File(destinationC));
        writerE = new PrintWriter(new File(destinationE));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of list of food to file
    public void write(ListOfFood lofc, ListOfFood lofe) {
        JSONObject jsonc = lofc.toJson();
        JSONObject jsone = lofe.toJson();
        saveToFile(jsonc.toString(TAB), jsone.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writerC.close();
        writerE.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String jsonc, String jsone) {
        writerC.print(jsonc);
        writerE.print(jsone);
    }
}
