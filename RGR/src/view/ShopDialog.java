package view;


import entitys.Shop;

import javax.swing.*;

public class ShopDialog extends AbstractDialog{


    private Shop shop;

    JTextField addressField = new JTextField();
    public ShopDialog() {

        //structure
        setShop();
        pack();
        //end structure
    }
    public void setShop(){
        addressField.setBorder(BorderFactory.createTitledBorder("Address"));
        getMainContent().add(addressField);
    }

    public void setShopDialog(Shop shop){
        this.shop = shop;
        addressField.setText(shop.getAddress());
        getNameField().setText(shop.getName());
        getIdField().setText(String.valueOf(shop.getId()));
    }

    public ShopDialog(Shop shop) {
        this();
        this.shop = shop;
        setShop();
        setShopDialog(shop);
        pack();

    }

    @Override
    protected void onOK() {
        shop = new Shop(Integer.parseInt(getIdField().getText()), getNameField().getText(), addressField.getText());
        dispose();

    }

    public Shop getShop() {
        return shop;
    }

    public static void main(String[] args) {
        ShopDialog dialog = new ShopDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
