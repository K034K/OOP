package view;

import javax.swing.*;

public class SellerDialog extends AbstractDialog {

    JTextField surnameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();

    public SellerDialog() {
        //structure
        setSeller();


        pack();
        //end structure
    }

    public void setSeller() {

        surnameField.setBorder(BorderFactory.createTitledBorder("Surname"));
        addressField.setBorder(BorderFactory.createTitledBorder("Address"));
        phoneField.setBorder(BorderFactory.createTitledBorder("Phone"));
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));

        JPanel mainContent = getMainContent();
        mainContent.add(surnameField);
        mainContent.add(addressField);
        mainContent.add(phoneField);
        mainContent.add(emailField);
    }

    public static void main(String[] args) {
        SellerDialog dialog = new SellerDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
