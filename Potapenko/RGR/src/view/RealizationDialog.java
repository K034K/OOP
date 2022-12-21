package view;


import entitys.Realization;

import javax.swing.*;

public class RealizationDialog extends AbstractDialog {

    JTextField quantityField = new JTextField();
    JTextField priceField = new JTextField();

    private Realization realization;

    public RealizationDialog() {
        //structure

        setRealiztionFields();

        pack();
        //end structure
    }

    public RealizationDialog(Realization realization) {
        this();
        this.realization = realization;
        setRealiztionFields();
        setRealizationDialog(realization);
        pack();
    }

    @Override
    protected void onOK() {
        realization = new Realization(Integer.parseInt(getIdField().getText()), Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
        dispose();
    }

    public Realization getRealization() {
        return realization;
    }

    private void setRealiztionFields() {
        quantityField.setBorder(BorderFactory.createTitledBorder("Quantity"));
        priceField.setBorder(BorderFactory.createTitledBorder("Price"));


        JPanel mainContent = getMainContent();

        mainContent.add(quantityField);
        mainContent.add(priceField);
        mainContent.setBorder(BorderFactory.createTitledBorder("Realization"));


        quantityField.setSize(100, 30);
        priceField.setSize(100, 30);
        getNameField().setVisible(false);

    }

    private void setRealizationDialog(Realization realization) {
        this.realization = realization;
        quantityField.setText(String.valueOf(realization.getQuantity()));
        priceField.setText(String.valueOf(realization.getPrice()));
        getIdField().setText(String.valueOf(realization.getId()));
    }
    public static void main(String[] args) {
        RealizationDialog dialog = new RealizationDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}