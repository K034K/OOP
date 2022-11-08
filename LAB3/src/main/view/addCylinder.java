package view;

import javax.swing.*;
import java.awt.event.*;

import model.Cylinder;
import model.Wood;
import store.WoodDirectory;


public class addCylinder extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField radiusField;
    private JTextField HeightField;
    private JComboBox WoodSelect;

    private Cylinder cylinder;

    public addCylinder() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        radiusField.setBorder(BorderFactory.createTitledBorder("Radius"));
        HeightField.setBorder(BorderFactory.createTitledBorder("Height"));
        WoodSelect.setBorder(BorderFactory.createTitledBorder("Wood Type"));

        setSize(500, 500);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void setWoodDirectory(WoodDirectory wd) {
        ComboBoxModel<Object> model = new DefaultComboBoxModel<>(wd.get());
        WoodSelect.setModel(model);
    }

    public Cylinder getCylinder() {
        return cylinder;
    }


    private void onOK() {
        // add your code here
        float radius = Float.parseFloat(radiusField.getText());
        float height = Float.parseFloat(HeightField.getText());
        Wood wood = (Wood) WoodSelect.getSelectedItem();
        Cylinder cylinder = new Cylinder(wood, radius, height);


        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        addCylinder dialog = new addCylinder();
        dialog.pack();
        System.exit(0);
    }
}
