package main;

import javax.swing.*;
import java.util.Arrays;

public class List extends JDialog {
    private JPanel contentPane;
    private JFormattedTextField surnameFormattedTextField;
    private JCheckBox budjetCheckBox;
    private JFormattedTextField marksFormattedTextField;
    private JButton calculateButton;
    private JTextArea Results;


    // surames and marks data arrays
    private String surnames[] = new String[100];

    private int marks[][] = new int[100][20];

    public List() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(calculateButton);
        calculateButton.addActionListener(e -> onCalculate());

    }

    private void onCalculate() {
        String surname = surnameFormattedTextField.getText(); // get surname from text field
        boolean budjet = budjetCheckBox.isSelected(); // get budjet from checkbox
        String mark = marksFormattedTextField.getText(); // get marks from text field
        String[] marksStrArr = mark.split(" "); // split marks by space
        int length = marksStrArr.length;
        Integer[] marksIntArr = new Integer[length]; // create array for marks
        for (int i = 0; i < marksStrArr.length; i++) {
            marksIntArr[i] = from100to5(Integer.parseInt(marksStrArr[i])); // convert marks from string to int
        }
        int sum = 0;
        for (Integer integer : marksIntArr) {
            sum += integer; // calculate sum of marks
        }
        double average = sum / marksIntArr.length; // calculate average mark
        Integer scholarship = scholarship(average, budjet, has2(marksIntArr)); // calculate scholarship
        //append results to text pane
        Results.append("Surname: " + surname + " Marks: " + Arrays.toString(marksIntArr) + "\nScholarship: " + scholarship + "\n");


    }
    public Integer from100to5(int mark){
        if (mark >= 90) return 5;
        if (mark >= 80) return 4;
        if (mark >= 70) return 3;
        if (mark >= 60) return 2;
        if (mark >= 50) return 1;
        return 0;
    }


    public static Integer scholarship(double mark, boolean budjet, boolean has2){ // calculate scholarship
        if (budjet && !has2) {
            if (mark >= 5) return 2000;
            if (mark >= 4) return 1500;
        }
        return 0;
    }
    public static Boolean has2(Integer[] marks){  // check if student has 2

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] <= 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List dialog = new List();
        dialog.setTitle("Mrynskyi Vladyslav KI-211 Scholarship Calculator");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
