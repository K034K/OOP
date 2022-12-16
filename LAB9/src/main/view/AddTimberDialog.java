package view;

import javax.swing.*;
import java.awt.event.*;

import model.Timber;
import model.Wood;
import store.WoodDirectory;

public class AddTimberDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField Length;
    private JTextField Height;

    private JTextField Width;

    private JComboBox WoodSelect;

    private Timber timber;

    public Timber getTimber() {
        return timber;
    }

    public AddTimberDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        Length.setBorder(BorderFactory.createTitledBorder("Length,m"));
        Height.setBorder(BorderFactory.createTitledBorder("Height,m"));
        Width.setBorder(BorderFactory.createTitledBorder("Width,m"));
        WoodSelect.setBorder(BorderFactory.createTitledBorder("Wood Selection"));

        setSize(500, 500);

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

    public void setWoodDirectory(WoodDirectory wd) {
        ComboBoxModel<Object> model = new DefaultComboBoxModel<>(wd.get());
        WoodSelect.setModel(model);
    }

    private void onOK() throws Exception {
        // add your code here
        float length = Float.parseFloat(Length.getText());
        float height = Float.parseFloat(Height.getText());
        float width = Float.parseFloat(Width.getText());
        Wood wood = (Wood) WoodSelect.getSelectedItem();
        timber = new Timber(wood, length, width, height);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddTimberDialog dialog = new AddTimberDialog();
        dialog.pack();
        System.exit(0);
    }
}
