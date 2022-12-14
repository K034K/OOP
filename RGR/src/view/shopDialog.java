package view;

import entitys.shop;

import javax.swing.*;
import java.awt.event.*;

public class shopDialog extends JDialog {


    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    protected JTextField nameField;
    protected JTextField idField;
    protected JTextField addressField;

    private shop shop;

    public shopDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        nameField.setBorder(BorderFactory.createTitledBorder("Name"));
        idField.setBorder(BorderFactory.createTitledBorder("ID"));
        addressField.setBorder(BorderFactory.createTitledBorder("Address"));

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

        shop = new shop(Integer.parseInt(idField.getText()), nameField.getText(), addressField.getText());
        dispose();
    }


    public shop getShop() {
        return shop;
    }




    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        shopDialog dialog = new shopDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
