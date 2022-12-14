package view;

import javax.swing.*;
import java.awt.*;

public class sellerDialog extends shopDialog{

    protected JTextField emailField = new JTextField();


    public sellerDialog() {
        super();

        //sellerDialog.getContentPane().add(emailField);
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));


    }

    public void addToContentPane(JComponent component) {

    }

    public static void main(String[] args) {
        sellerDialog dialog = new sellerDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
