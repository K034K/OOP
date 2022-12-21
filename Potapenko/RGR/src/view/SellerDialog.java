package view;

import entitys.Seller;

import javax.swing.*;

public class SellerDialog extends AbstractDialog {

    JTextField surnameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField emailField = new JTextField();

    private Seller seller;

    public SellerDialog() {
        //structure
        setSeller();

        pack();
        //end structure
    }

    public SellerDialog(Seller seller) {
        this();
        this.seller = seller;
        setSeller();
        setSellerDialog(seller);
        pack();
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

    private void setSellerDialog(Seller seller) {
        this.seller = seller;
        surnameField.setText(seller.getSurname());
        addressField.setText(seller.getAddress());
        phoneField.setText(seller.getPhone());
        emailField.setText(seller.getEmail());
        getNameField().setText(seller.getName());
        getIdField().setText(String.valueOf(seller.getId()));
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
