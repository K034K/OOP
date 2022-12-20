package view;


import javax.swing.*;

public class RealizationDialog extends AbstractDialog {

    JTextField quantityField = new JTextField();
    JTextField priceField = new JTextField();
    JTextField dateField = new JTextField();

    public RealizationDialog() {
        //structure

        setRealiztionFields();

        pack();
        //end structure
    }

    private void setRealiztionFields() {
        quantityField.setBorder(BorderFactory.createTitledBorder("Quantity"));
        priceField.setBorder(BorderFactory.createTitledBorder("Price"));
        dateField.setBorder(BorderFactory.createTitledBorder("Date"));

        JPanel mainContent = getMainContent();

        mainContent.add(quantityField);
        mainContent.add(priceField);
        mainContent.add(dateField);

        quantityField.setSize(100, 30);
        priceField.setSize(100, 30);
        dateField.setSize(100, 30);
    }


    public static void main(String[] args) {
        RealizationDialog dialog = new RealizationDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
