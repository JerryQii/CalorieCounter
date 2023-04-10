package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launchpage extends JFrame implements ActionListener {
    private JButton button;
    private JButton button1;

    public Launchpage() {
        super("Launch Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(200,130);
        setVisible(true);
        GridLayout layout = new GridLayout(0,1);
        setLayout(layout);

        button = new JButton("Open");
        button.setActionCommand("Open");
        button.addActionListener(this);
        button1 = new JButton("Close");
        button1.setActionCommand("Close");
        button1.addActionListener(this);

        JLabel text = new JLabel("Welcome using this App!");
        text.setHorizontalAlignment(JLabel.HORIZONTAL);

        add(text);
        add(button);
        add(button1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open")) {
            dispose();
            CounterApp app = new CounterApp();
        }
        if (e.getActionCommand().equals("Close")) {
            dispose();
        }
    }
}
