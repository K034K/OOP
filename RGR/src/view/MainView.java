package view;

import entitys.product;
import entitys.realization;
import entitys.seller;
import entitys.shop;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

public class MainView {
    private JTree ShopsTree;
    private JPanel panel1;
    private JPanel ButtonsPanel;
    private JButton AddButton;
    private JButton DeleteButton;
    private JButton EditButton;
    private JButton StoreButton;
    private JButton restoreButton;
    private JButton calculateButton;

    public MainView() {
        JFrame frame = new JFrame("MainView");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        onWindowOpened();
    }

    public static void main(String[] args) {
        new MainView();
    }

    protected TreeModel getShopsTreeModel() throws Exception {
        shop shop1 = new shop(1, "Shop1", "Address1");
        seller seller1 = new seller(1, "Seller1", "Surname1", "Address1", "Phone1", "Email1");
        product product1 = new product(1, "Product1", "Description1", 1);
        realization realization1 = new realization(1, 1, 1, null);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(shop1);
        DefaultMutableTreeNode seller = new DefaultMutableTreeNode(seller1);
        DefaultMutableTreeNode product = new DefaultMutableTreeNode(product1);
        DefaultMutableTreeNode realization = new DefaultMutableTreeNode(realization1);

        root.add(seller);
        seller.add(product);
        product.add(realization);


        return (new JTree(root)).getModel();
    }

    protected void onWindowOpened() {
       try{
           ShopsTree.setModel(getShopsTreeModel());
           for (int i = 0; i < ShopsTree.getRowCount(); i++) {
               ShopsTree.expandRow(i);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

}
