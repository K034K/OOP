package view;

import entitys.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ProductDialog extends AbstractDialog {
    JTextField descriptionField = new JTextField();
    JTextField priceField = new JTextField();

    Product product;

    public ProductDialog() {
        //structure
        setProduct();

        pack();
        //end structure
    }

    @Override
    protected void onOK() {
        product = new Product(Integer.parseInt(getIdField().getText()), getNameField().getText(), descriptionField.getText(), Double.parseDouble(priceField.getText()));
        dispose();

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct() {

        descriptionField.setBorder(BorderFactory.createTitledBorder("Description"));
        priceField.setBorder(BorderFactory.createTitledBorder("Price"));

        JPanel mainContent = getMainContent();

        mainContent.add(descriptionField);
        mainContent.add(priceField);
        mainContent.setBorder(BorderFactory.createTitledBorder("Product"));

    }


    public static void main(String[] args) {
        ProductDialog dialog = new ProductDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
