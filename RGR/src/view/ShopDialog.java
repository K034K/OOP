package view;


import javax.swing.*;

public class ShopDialog extends AbstractDialog{


    public ShopDialog() {

        //structure
        JTextField addressField = new JTextField();
        addressField.setBorder(BorderFactory.createTitledBorder("Address"));
        getMainContent().add(addressField);
        pack();
        //end structure
    }

    public static void main(String[] args) {
        ShopDialog dialog = new ShopDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
