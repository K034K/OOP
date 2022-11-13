package view;

import javax.swing.*;

public class MainView {
    private JTree ShopsTree;
    private JPanel panel1;

    public MainView() {
        JFrame frame = new JFrame("MainView");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }


}
