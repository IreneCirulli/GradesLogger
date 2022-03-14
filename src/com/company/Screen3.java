package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen3 extends JFrame{
    private JPanel panelMain;
    private JTextField oneTextField;
    private JTextField twoTextField;
    private JTextField threeTextField;
    private JTextField fourTextField;
    private JTextField fiveTextField;
    private JTextField sixTextField;
    private JTextField sevenTextField;
    private JLabel oneLabel;
    private JLabel sevenLabel;
    private JLabel sixLabel;
    private JLabel twoLabel;
    private JLabel threeLabel;
    private JLabel fiveLabel;
    private JLabel fourLabel;
    private JButton CGBButton;

    Screen3() {
        super("Grade Logbook");
        this.setContentPane(this.panelMain);
        this.pack();

        CGBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grades.oneg = Double.parseDouble(oneTextField.getText());
                Grades.twog = Double.parseDouble(twoTextField.getText());
                Grades.threeg = Double.parseDouble(threeTextField.getText());
                Grades.fourg = Double.parseDouble(fourTextField.getText());
                Grades.fiveg = Double.parseDouble(fiveTextField.getText());
                Grades.sixg = Double.parseDouble(sixTextField.getText());
            }
        });


    }
}
