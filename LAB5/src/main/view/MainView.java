package view;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.Date;

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
    private JMenuItem StoreToFile;
    private JMenuItem RestoreFromFile;
    private JMenuItem ShowProtocol;

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

        File.add(StoreToFile);
        File.add(RestoreFromFile);
        File.add(ShowProtocol);

        // File Protocol Buffered Writer
        //We added when time and student who did it
        Date date = new Date();
        try {
            BufferedWriter prot = new BufferedWriter(new FileWriter("protocol.txt", true));
            prot.write("Mrynskiy Vladyslav ");
            prot.write(date.toString());
            prot.newLine();
            prot.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // now we do it for all menu items


        //Wood menu

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


        // Product Menu
        AddTimberMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTimberDialog();
                writeString("Timber added " + date.toString() + " \n" + ps.toString());
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
                writeString("Cylinder added" + date.toString() + " \n" + ps.toString());
            }
        });

        AddWasteDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWasteDialog();
                writeString("Waste added " + date.toString() + " \n" + ps.toString());
            }

        });

        //File menu
        StoreToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeToFile();
            }
        });

        RestoreFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restoreFromFile();
            }

        });

        ShowProtocol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showProtocol();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }

    private void writeString(String s) {
        try {
            BufferedWriter protocol = new BufferedWriter(new FileWriter("protocol.txt", true));
            protocol.write(s);
            protocol.newLine();
            protocol.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProtocol() throws FileNotFoundException {
        BufferedReader file = new BufferedReader(new FileReader("protocol.txt"));
        try {
            String line;
            while ((line = file.readLine()) != null) {
                Output.append(line);
                Output.append("\n");
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void restoreFromFile() {
        File filewd = new File("wd.object");
        File fileps = new File("ps.object");
        try {
            FileInputStream fis = new FileInputStream(filewd);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();
            FileInputStream fis2 = new FileInputStream(fileps);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            ps = (ProductStore) ois2.readObject();
            ois2.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void storeToFile() {
        java.io.File file = new File("wd.object");
        java.io.File file2 = new File("ps.object");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(wd);
            oos.close();
            FileOutputStream fos2 = new FileOutputStream(file2);
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos2.writeObject(ps);
            oos2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
