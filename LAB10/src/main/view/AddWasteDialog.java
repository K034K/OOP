package view;

import model.Waste;

import javax.swing.*;
import java.awt.event.*;

public class AddWasteDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField WasteWeight;

    private Waste waste;

    public AddWasteDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        WasteWeight.setBorder(BorderFactory.createTitledBorder("Weight,kg"));
        setSize(200, 200);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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

    private void onOK() throws Exception {

        int weight = Integer.parseInt(WasteWeight.getText());
        waste = new Waste(weight);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddWasteDialog dialog = new AddWasteDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public Waste getWaste() {
        return waste;
    }
}
