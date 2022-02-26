package com.company;

import javax.swing.*;

public class Screen2 extends JFrame {
    private JPanel panelMain;
    private JLabel avLabel;
    private JLabel totLabel;


    Screen2() {
        super("Term Overlook");
        this.setContentPane(this.panelMain);
        this.pack();

        avLabel.setText("Number grade: " + Grades.finalmarks + " Percentage Grade: " + Grades.average);
        totLabel.setText("All of the grades are: " + Grades.allmarks);


    }

}
