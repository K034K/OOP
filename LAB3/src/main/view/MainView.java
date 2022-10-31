package view;

import javax.swing.*;

import java.awt.event.*;

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

        ShowWoodMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWoodMenu();
            }
        });
        Info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Info info = new Info();
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

    protected void addWoodDialog() {
        woodDialog = new WoodDialog();
        woodDialog.setVisible(true);
        Wood wood = woodDialog.getWood();
        if (wood != null) {
            wd.addWood(wood);
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
