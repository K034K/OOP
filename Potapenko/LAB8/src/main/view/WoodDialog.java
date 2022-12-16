package view;

import model.Wood;

import javax.swing.*;
import java.awt.event.*;

public class WoodDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField densityField;

    private Wood wood;

    public Wood getWood() {
        return wood;
    }

    public WoodDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(500, 300);
        idField.setBorder(BorderFactory.createTitledBorder("ID"));
        nameField.setBorder(BorderFactory.createTitledBorder("Name"));
        densityField.setBorder(BorderFactory.createTitledBorder("Density"));

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

    private void onOK() {
        // add your code here
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        float density = Float.parseFloat(densityField.getText());
        wood = new Wood(id, name, density);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        WoodDialog dialog = new WoodDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
