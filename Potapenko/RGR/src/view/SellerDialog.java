package view;

import entitys.Seller;

import javax.swing.*;

public class SellerDialog extends AbstractDialog {

    JTextField surnameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();

    Seller seller;

    public SellerDialog() {
        //structure
        setSeller();

        pack();
        //end structure
    }

    @Override
    protected void onOK() {
        seller = new Seller(Integer.parseInt(getIdField().getText()), getNameField().getText(), surnameField.getText(), addressField.getText(), phoneField.getText(), emailField.getText());
        dispose();
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
        mainContent.setBorder(BorderFactory.createTitledBorder("Seller"));
    }

    public Seller getSeller() {
        return seller;
    }



    public static void main(String[] args) {
        SellerDialog dialog = new SellerDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
