package view;

import javax.swing.*;

import java.awt.event.*;

import model.Cylinder;
import model.Timber;
import model.Wood;
import store.*;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private JTextArea Output;
    private JMenuBar menuBar;
    private JMenu File;
    private JMenu WoodMenu;
    private JMenu ProductMenu;
    private JMenuItem ShowWoodMenu;
    private JMenuItem AddWoodMenu;
    private JMenuItem DeleteWoodMenu;
    private JMenuItem EditWoodMenu;
    private JMenuItem ShowAllProductsMenu;
    private JMenu AddProductMenu;
    private JMenuItem AddTimberMenu;
    private JMenuItem Info;
    private JMenuItem AddCylinderMenu;
    private JMenuItem AddWasteDialog;

    private WoodDialog woodDialog;


    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();

    public MainView() {
        super("MainView");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setJMenuBar(menuBar);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("MainView");

        AddProductMenu.add(AddTimberMenu);
        AddProductMenu.add(AddCylinderMenu);
        AddProductMenu.add(AddWasteDialog);
        AddProductMenu.setText("Add Product");

        ShowWoodMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWoodMenu();
            }
        });
        Info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                onInfoClick();
            }
        });
        AddWoodMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWoodDialog();
            }
        });
        AddTimberMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTimberDialog();
            }
        });
        ShowAllProductsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllProducts();
            }
        });
        AddCylinderMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCylinderDialog();
            }
        });

        AddWasteDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWasteDialog();
            }
        });
    }

    private void addWasteDialog() {

        AddWasteDialog addWasteDialog = new AddWasteDialog();
        addWasteDialog.setVisible(true);
        if (addWasteDialog.getWaste() != null) {
            ps.add(addWasteDialog.getWaste());
        }
        showAllProducts();
    }

    private void addCylinderDialog() {
        AddCylinderDialog ac = new AddCylinderDialog();
        ac.setWoodDirectory(wd);
        ac.setVisible(true);
        Cylinder cylinder = ac.getCylinder();
        if (cylinder != null) {
            ps.add(cylinder);
        }
        showAllProducts();
    }

    private void onInfoClick() {
        Info info = new Info();
        info.setVisible(true);

    }

    private void showAllProducts() {
        Output.append(ps.toString());
    }

    private void addTimberDialog() {
        AddTimberDialog addTimberDialog = new AddTimberDialog();
        addTimberDialog.setWoodDirectory(wd);
        addTimberDialog.setVisible(true);
        Timber timber = addTimberDialog.getTimber();
        if (timber != null)
            ps.add(timber);
        showAllProducts();


    }


    //wood menus
    protected void addWoodDialog() {
        woodDialog = new WoodDialog();
        woodDialog.setVisible(true);
        Wood wood = woodDialog.getWood();
        if (wood != null) {
            wd.add(wood);
        }
        showWoodMenu();
    }

    private void showWoodMenu() {
        Output.append(wd.toString());
    }

    public static void main(String[] args) {
        new MainView();
    }

}
