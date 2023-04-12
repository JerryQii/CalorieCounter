package ui;

import model.Event;
import model.EventLog;
import model.Food;
import model.ListOfFood;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;


// Calorie Counter App based on GUI
public class CounterApp extends JFrame implements ActionListener, WindowListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private double calories;
    private JLabel giga;
    private JPanel toolpanel;
    private JList<Food> fclist;
    private JList<Food> felist;
    private ListOfFood lofc;
    private ListOfFood lofe;
    private static final String JSON_STORE_c = "./data/ListOfFoodChoice.json";
    private static final String JSON_STORE_e = "./data/ListOfFoodEaten.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReaderC;
    private JsonReader jsonReaderE;
    DefaultListModel<Food> modelc;
    DefaultListModel<Food> modele;
    JPanel fcpanel = new JPanel();


    // MODIFIES: this
    // EFFECTS: run the Counter App with GUI
    public CounterApp() {
        super("Calorie Counter");
        initializeJson();
        initializeFoodlist();
        initializeFrame();
        initializeJlist();
        initializepanels();
        initializeLabel();
        initializeButtons();

    }

    // MODIFIES: this
    // EFFECTS: initialize the JsonWriter and JsonReader
    private void initializeJson() {
        jsonWriter = new JsonWriter(JSON_STORE_c, JSON_STORE_e);
        jsonReaderC = new JsonReader(JSON_STORE_c);
        jsonReaderE = new JsonReader(JSON_STORE_e);
    }

    // MODIFIES: this
    // EFFECTS: initialize the list of food choices and food eaten
    private void initializeFoodlist() {
        lofc = new ListOfFood();
        lofe = new ListOfFood();
        Food ramen = new Food("ramen", "bowl", 550, 1);
        Food pizza = new Food("pizza", "slice", 225, 2);
        Food rameneaten = new Food(ramen,1.5,3);
        lofc.addFood(ramen);
        lofc.addFood(pizza);
        lofe.addFood(rameneaten);
    }

    // MODIFIES: this
    // EFFECTS: initialize the buttons
    private void initializeButtons() {
        JButton savebutton = new JButton("Save the current lists");
        savebutton.setActionCommand("save");
        savebutton.addActionListener(this);
        toolpanel.add(savebutton);

        JButton loadbutton = new JButton("Load the saved lists");
        loadbutton.setActionCommand("load");
        loadbutton.addActionListener(this);
        toolpanel.add(loadbutton);

        JButton addbutton = new JButton("add to list of food eaten");
        addbutton.setActionCommand("add");
        addbutton.addActionListener(this);
        toolpanel.add(addbutton);

        JButton deletebutton = new JButton("delete from list of food eaten");
        deletebutton.setActionCommand("delete");
        deletebutton.addActionListener(this);
        toolpanel.add(deletebutton);

        JButton calbutton = new JButton("calculate total calorie");
        calbutton.setActionCommand("calculate");
        calbutton.addActionListener(this);
        toolpanel.add(calbutton);
    }

    // MODIFIES: this
    // EFFECTS: initialize the labels
    private void initializeLabel() {
        JLabel headlabel = new JLabel("Ready to lose some weight?");
        headlabel.setFont(new Font("ITALIC",Font.ITALIC,21));
        headlabel.setForeground(Color.BLACK);
        headlabel.setHorizontalAlignment(JLabel.HORIZONTAL);
        headlabel.setVerticalAlignment(JLabel.TOP);
        add(headlabel, BorderLayout.NORTH);

    }

    // MODIFIES: this
    // EFFECTS: initialize the Jlists
    private void initializeJlist() {
        fclist = new JList<>();
        modelc = new DefaultListModel<>();
        fclist.setModel(modelc);
        refreshModel(lofc,modelc);

        felist = new JList<>();
        modele = new DefaultListModel<>();
        felist.setModel(modele);
        refreshModel(lofe,modele);
    }

    // MODIFIES: this
    // EFFECTS: reload the model with corresponding list of food
    private void refreshModel(ListOfFood lof, DefaultListModel dm) {
        dm.removeAllElements();
        for (Food f : lof.getList()) {
            dm.addElement(f);
        }
    }


    // MODIFIES: this
    // EFFECTS: initialize the panels
    private void initializepanels() {
        fcpanel.setPreferredSize(new Dimension(300, 6000));
        fcpanel.setBackground(new Color(119,243,123));
        fcpanel.add(fclist);
        add(fcpanel, BorderLayout.WEST);
        JPanel fepanel = new JPanel();
        fepanel.setBackground(Color.BLUE);
        fepanel.add(felist);
        fepanel.setPreferredSize(new Dimension(300, 6000));
        add(fepanel, BorderLayout.EAST);

        toolpanel = new JPanel();
        toolpanel.setBackground(Color.RED);
        toolpanel.setLayout(new FlowLayout());
        add(toolpanel, BorderLayout.SOUTH);

        JPanel picturepanel = new JPanel();
        picturepanel.setBackground(Color.GRAY);
        picturepanel.setLayout(new GridLayout());
        giga = new JLabel(new ImageIcon("data/giga2.jpg"));
        giga.setText("<html>Left side is your list of food choice<br>Right side is your list"
                + " of food eaten<br>The total calories eaten is  <html>" + calories);
        giga.setVerticalTextPosition(JLabel.BOTTOM);
        giga.setHorizontalTextPosition(JLabel.CENTER);
        picturepanel.add(giga);
        add(picturepanel, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: initialize the jframe
    private void initializeFrame() {
        this.addWindowListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        getContentPane().setBackground(new Color(216,177,240));
        setLayout(new BorderLayout());
    }

    /*
     * MODIFIES: this
     * EFFECTS: deal with buttons' actions
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("save")) {
            savelist();
        }
        if (e.getActionCommand().equals("load")) {
            loadlist();
        }
        if (e.getActionCommand().equals("add")) {
            addtolist();
        }
        if (e.getActionCommand().equals("delete")) {
            deletefromlist();
        }
        if (e.getActionCommand().equals("calculate")) {
            calculate();
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: calculate the total calories eaten
     */
    private void calculate() {
        calories = lofe.totalCalorie();
        giga.setText("<html>Left side is your list of food choice<br>Right side is your list"
                + " of food eaten<br>The total calories eaten is  <html>" + calories);
    }

    /*
     * MODIFIES: this
     * EFFECTS: delete user's eaten food in the list of food eaten
     */
    private void deletefromlist() {
        Food f = felist.getSelectedValue();
        lofe.deleteFood(f.getId());
        lofe.rearrange();
        refreshModel(lofe, modele);
    }

    /*
     * MODIFIES: this
     * EFFECTS: add user's eaten food from list of food choice
     */
    private void addtolist() {
        Food f = fclist.getSelectedValue();
        Double inputAmount = Double.valueOf(JOptionPane.showInputDialog("How many units did you have?"));
        int newid = lofe.getList().size() + 1;
        Food newfood = new Food(f, inputAmount,newid);
        lofe.addFood(newfood);
        refreshModel(lofe,modele);
    }

    // MODIFIES: this
    // EFFECTS: save the current list of food eaten and list of food choice as json files.
    private void savelist() {
        try {
            jsonWriter.open();
            jsonWriter.write(lofc, lofe);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Lists successfully saved", "Congrats",JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Lists failed to save", "Noooo",JOptionPane.WARNING_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: load the saved json files of list of food eaten and list of food choice to the program.
    private void loadlist() {
        try {
            lofc = jsonReaderC.read();
            lofe = jsonReaderE.read();
            refreshModel(lofc,modelc);
            refreshModel(lofe,modele);
            JOptionPane.showMessageDialog(null, "Lists successfully loaded", "Hehe",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lists failed to load", "Noooo",JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //
    }

    /*
     * EFFECTS: print the EventLog to the console once the window is closed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        for (Event event:EventLog.getInstance()) {
            System.out.println(event.toString());
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //
    }
}
