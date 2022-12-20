package view;

import entitys.Product;
import entitys.Realization;
import entitys.Seller;
import entitys.Shop;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton InfoButton;

    public MainView() {
        JFrame frame = new JFrame("MainView");
        //add margins to ShopsTree
        ShopsTree.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        onWindowOpened();

        //InfoButton action

        InfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                onInfoClick();
            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddClick();
            }
        });

    }

    private void onAddClick() {
        DefaultMutableTreeNode selectedNode = getSelectedNode();
        if (selectedNode == null || selectedNode.getUserObject() instanceof Realization) {
            return;
        }


    }

    private void onInfoClick() {
        Info info = new Info();
        info.setVisible(true);

    }

    public static void main(String[] args) {
        new MainView();
    }

    protected TreeModel getShopsTreeModel() throws Exception {
        Shop shop1 = new Shop(1, "Shop1", "Address1");
        Seller seller1 = new Seller(1, "Seller1", "Surname1", "Address1", "Phone1", "Email1");
        Product product1 = new Product(1, "Product1", "Description1", 1);
        Realization realization1 = new Realization(1, 1, 1, null);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(shop1);
        DefaultMutableTreeNode seller = new DefaultMutableTreeNode(seller1);
        DefaultMutableTreeNode product = new DefaultMutableTreeNode(product1);
        DefaultMutableTreeNode realization = new DefaultMutableTreeNode(realization1);

        root.add(seller);
        seller.add(product);
        product.add(realization);


        return (new JTree(root)).getModel();
    }

    private DefaultMutableTreeNode getSelectedNode() {
        return (DefaultMutableTreeNode) ShopsTree.getLastSelectedPathComponent();
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
