package view;


import entitys.Shop;

import javax.swing.*;

public class ShopDialog extends AbstractDialog{


    Shop shop;

    JTextField addressField = new JTextField();
    public ShopDialog() {

        //structure
        addressField.setBorder(BorderFactory.createTitledBorder("Address"));
        getMainContent().add(addressField);
        pack();
        //end structure
    }

    @Override
    protected void onOK() {
        shop = new Shop(Integer.parseInt(getIdField().getText()), getNameField().getText(), addressField.getText());
        dispose();


    }

    public static void main(String[] args) {
        ShopDialog dialog = new ShopDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
