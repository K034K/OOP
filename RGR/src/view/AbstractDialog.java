package view;

import javax.swing.*;
import java.awt.event.*;

public abstract class AbstractDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JPanel mainContent;

    public AbstractDialog() {
        setContentPane(contentPane);

        idField.setBorder(BorderFactory.createTitledBorder("Id"));
        nameField.setBorder(BorderFactory.createTitledBorder("Name"));
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.add(idField);
        mainContent.add(nameField);

        idField.setSize(100, 30);
        nameField.setSize(100, 30);

        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    protected JPanel getMainContent() {
        return mainContent;
    }

    protected JTextField getIdField() {
        return idField;
    }

    protected JTextField getNameField() {
        return nameField;
    }

    protected void setIdField(String id) {

        idField.setText(id);
    }

    protected void setNameField(String name) {
        nameField.setText(name);
    }



}
