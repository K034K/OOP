package view;

import javax.swing.*;

public class ProductDialog extends AbstractDialog {
    JTextField descriptionField = new JTextField();
    JTextField priceField = new JTextField();

    public ProductDialog() {
        //structure
        setProduct();
        pack();
        //end structure
    }

    public void setProduct() {

        descriptionField.setBorder(BorderFactory.createTitledBorder("Description"));
        priceField.setBorder(BorderFactory.createTitledBorder("Price"));

        JPanel mainContent = getMainContent();
        mainContent.add(descriptionField);
        mainContent.add(priceField);

        getNameField().setVisible(false);

    }

    public static void main(String[] args) {
        ProductDialog dialog = new ProductDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
