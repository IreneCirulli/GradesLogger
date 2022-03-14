package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JFrame{
    private JPanel panelMain;
    private JTextField textname;
    private JTextField textmark;
    private JTextField texttotmark;
    private JButton termButton;
    private JRadioButton quizRadioButton;
    private JRadioButton testRadioButton;
    private JRadioButton homeworkRadioButton;
    private JButton addButton;
    private JLabel titleLabel;
    private JList listGrades;
    private JLabel nameLabel;
    private JLabel marksLabel;
    private JLabel totmarksLabel;
    private JLabel perLabel;
    private JButton perButton;
    private JButton updateButton;
    private JLabel typeLabel;
    private JLabel tLabel;
    private JButton edButton;
    private ArrayList<Grades> grade;
    private DefaultListModel listGradesModel;
    static int m = 0;
    static double[] orderper;


    Screen() {
        super("Grade Logbook");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        grade = new ArrayList<Grades>();
        listGradesModel = new DefaultListModel();
        listGrades.setModel(listGradesModel);

        ButtonGroup radiobuttonGroup = new ButtonGroup();
        radiobuttonGroup.add(quizRadioButton);
        radiobuttonGroup.add(testRadioButton);
        radiobuttonGroup.add(homeworkRadioButton);

        if(quizRadioButton.isSelected()) {
            tLabel.setText("Quiz");
        }
       else if(testRadioButton.isSelected()) {
                tLabel.setText("Test");
            }
        else if(homeworkRadioButton.isSelected()) {
            tLabel.setText("Homework");
        }

        termButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double av=0.0;
                double num;
                String av1 = " ";
                String num1;
                int min;
               orderper = new double[m];

                for(int i = 0; i < grade.size(); i++){
                   num = Double.parseDouble(grade.get(i).getPercentage());
                    av = num + av;
                }
                Grades.average = Double.toString(av/grade.size());
                Grades.finalmarks = Grades.getFinalMark(Grades.average);

                for (int k = 0; k < grade.size(); k++)
                    orderper[k] = Double.parseDouble(grade.get(k).getPercentage());

                for (int i = 0; i < grade.size()-1; i++)
                {
                    min = i;
                    for (int j = i+1; j < grade.size(); j++) {
                        if (orderper[j] < orderper[min])
                            min = j;
                    }

                    double temp = orderper[min];
                    orderper[min] = orderper[i];
                    orderper[i] = temp;
                }

                for(int i = 0; i < orderper.length; i++){
                    num1 =  String.valueOf(orderper[i]);
                    av1 = " " + av1 + " " + num1;
                }

                Grades.allmarks = av1;
                Screen2 screen = new Screen2();
                screen.setVisible(true);
            }
        });

        edButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Screen3 screen = new Screen3();
                screen.setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gradesNumber = listGrades.getSelectedIndex();
                Grades g = grade.get(gradesNumber);
                g.setName(textname.getText());
                g.setMarks(textmark.getText());
                g.setTotalmarks(texttotmark.getText());
                refreshGradeList();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grades g = new Grades(textname.getText(), textmark.getText(),
                        texttotmark.getText());
                grade.add(g);
                refreshGradeList();
            }
        });

        perButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = textname.getText();
                String b = textmark.getText();
                String c = texttotmark.getText();
                Grades num = new Grades(a,b,c);
                perLabel.setText(num.getPercentage()  + " %");
                m ++;
            }
        });

            listGrades.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int gradesNumber = listGrades.getSelectedIndex();
                    if (gradesNumber >= 0) {
                        Grades g = grade.get(gradesNumber);
                        textname.setText(g.getName());
                        textmark.setText(g.getMarks());
                        texttotmark.setText(g.getTotalmarks());
                        perLabel.setText(g.getPercentage() + " %");
                        addButton.setEnabled(true);
                    } else {
                        addButton.setEnabled(false);
                    }
                }
            });

        }

    public void refreshGradeList() {
        listGradesModel.removeAllElements();
        System.out.println("Removing all grades from list");
        for (Grades g : grade) {
            System.out.println("Adding grades to list: " + g.getName());
            listGradesModel.addElement(g.getName());
        }
    }

        public void addGrade(Grades g){
            grade.add(g);
            refreshGradeList();
        }
}
