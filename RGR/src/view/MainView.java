package view;

import entitys.Product;
import entitys.Realization;
import entitys.Seller;
import entitys.Shop;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

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
    private JPopupMenu popup;
    private JMenuItem CalculateAllRealization;


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

        //storeButton action and RestoreButton action
        StoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onStoreClick();
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRestoreClick();
            }
        });

        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteClick();
            }
        });

        EditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEditClick();
            }
        });
        addPopup(calculateButton, popup);
        CalculateAllRealization.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCalculateAllRealizationClick();
            }
        });
    }

    private void onCalculateAllRealizationClick() {
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) ShopsTree.getModel().getRoot();
        root.children().asIterator().forEachRemaining(shop -> {
            ((DefaultMutableTreeNode) shop).children().asIterator().forEachRemaining(seller -> {
                ((DefaultMutableTreeNode) seller).children().asIterator().forEachRemaining(realization -> {
                    sum.updateAndGet(v -> (double) (v + ((Realization) ((DefaultMutableTreeNode) realization).getUserObject()).getPrice()));
                });
            });
        });
        JOptionPane.showMessageDialog(null, "Sum of all realization is " + sum);
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                    showMenu(e);

            }


            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    private void onEditClick() {
        DefaultMutableTreeNode selectedNode = getSelectedNode();
        if (selectedNode == null) {
            JOptionPane.showMessageDialog(null, "Select node");
            return;
        }

        if(selectedNode.getUserObject() instanceof Shop) {
            ShopDialog dialog = new ShopDialog((Shop) selectedNode.getUserObject());
            dialog.setVisible(true);
            selectedNode.setUserObject(dialog.getShop());
            ShopsTree.updateUI();
        }else if(selectedNode.getUserObject() instanceof Seller){
            SellerDialog dialog = new SellerDialog((Seller) selectedNode.getUserObject());
            dialog.setVisible(true);
            selectedNode.setUserObject(dialog.getSeller());
            ShopsTree.updateUI();
        }else if(selectedNode.getUserObject() instanceof Product){
            ProductDialog dialog = new ProductDialog((Product) selectedNode.getUserObject());
            dialog.setVisible(true);
            selectedNode.setUserObject(dialog.getProduct());
            ShopsTree.updateUI();
        }else if(selectedNode.getUserObject() instanceof Realization){
            RealizationDialog dialog = new RealizationDialog((Realization) selectedNode.getUserObject());
            dialog.setVisible(true);
            selectedNode.setUserObject(dialog.getRealization());
            ShopsTree.updateUI();
        }

    }

    private void onDeleteClick() {
        DefaultMutableTreeNode selectedNode = getSelectedNode();
        selectedNode.removeFromParent();
        ShopsTree.updateUI();

    }

    private void onRestoreClick() {

        try {
            FileInputStream fileInputStream = new FileInputStream("store.object");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            ShopsTree.setModel((TreeModel) objectInputStream.readObject());
            objectInputStream.close();
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        expandAll();


    }

    private void onStoreClick() {
        if(ShopsTree.getModel().getRoot() == null){
            JOptionPane.showMessageDialog(null, "Nothing to store");
            return;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("store.object");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(ShopsTree.getModel());
            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    private void expandAll(){
        int row = 0;
        while (row < ShopsTree.getRowCount()) {
            ShopsTree.expandRow(row);
            row++;
        }
    }

    //adding nodes to tree
    private void onAddClick() {
        DefaultMutableTreeNode selectedNode = getSelectedNode();
        if (selectedNode.getUserObject() instanceof Realization) {
            return;
        }
        if (selectedNode.getUserObject() instanceof Shop) {
            SellerDialog dialog = new SellerDialog();
            dialog.pack();
            dialog.setVisible(true);
            Seller seller = dialog.getSeller();
            if (seller != null) {
                selectedNode.add(new DefaultMutableTreeNode(seller));
                ShopsTree.updateUI();
            }
        }
        if (selectedNode.getUserObject() instanceof Seller) {
            ProductDialog dialog = new ProductDialog();
            dialog.pack();
            dialog.setVisible(true);
            Product product = dialog.getProduct();
            if (product != null) {
                selectedNode.add(new DefaultMutableTreeNode(product));
                ShopsTree.updateUI();
            }
        }
        if (selectedNode.getUserObject() instanceof Product) {
            RealizationDialog dialog = new RealizationDialog();
            dialog.pack();
            dialog.setVisible(true);
            Realization realization = dialog.getRealization();
            if (realization != null) {
                selectedNode.add(new DefaultMutableTreeNode(realization));
                ShopsTree.updateUI();
            }
        }
        if (selectedNode.getUserObject()==null) {
            ShopDialog dialog = new ShopDialog();
            dialog.pack();
            dialog.setVisible(true);
            Shop shop = dialog.getShop();
            if (shop != null) {
                selectedNode.add(new DefaultMutableTreeNode(shop));
                ShopsTree.updateUI();
            }
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
        Shop shop1 = new Shop(1, "WellMart", "Address1");
        Seller seller1 = new Seller(1, "Oleg", "Petrenko", "Address1", "Phone1", "Email1");
        Product product1 = new Product(1, "Soap", "Description1", 1);
        Realization realization1 = new Realization(1, 1, 100);

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
        try {
            ShopsTree.setModel(getShopsTreeModel());
           expandAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
