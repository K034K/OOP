package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Info extends JFrame {
    private JPanel mainPanel;
    private JTextArea programDeveloper;

    private URL url = Info.class.getResource("/developer.jpg");
    private URL diagramUrl = Info.class.getResource("/diagram.png");
    private BufferedImage img;
    private BufferedImage diagramImg;

    {
        try {
            assert url != null;
            assert diagramUrl != null;
            img = javax.imageio.ImageIO.read(url);
            diagramImg = javax.imageio.ImageIO.read(diagramUrl);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        Image scaledImage = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);


        g2.drawImage(scaledImage, 0, 50, this);
        Image scaledDiagramImage = diagramImg.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        g2.drawImage(scaledDiagramImage, 200, 50, this);

    }


    public Info() {
        super("Info");
        this.setContentPane(mainPanel);
        programDeveloper.setText("Ім'я розробника: \n" +
                "Потапенко Дмитро\n" +
                "Група: KI-212\n" +
                "Тема:Мережа магазинів\n" +
                "Для реалізації завдання РГР потрібно створити дерево відповідно до вибраної теми. \n" +
                "Дерево має містити в собі магазини, продавців, товари, реалізації. \n" +
                "Для кожного з вузлів дерева потрібно реалізувати можливість додавання, видалення, редагування, \n" +
                "збереження в файл, відновлення з файлу, виведення інформації про вузол. \n" +
                "Магазин повинен мати адресу, id, назву. \n" +
                "Продавець повинен мати id, ім'я, прізвище,  телефон, мейл. \n" +
                "Товар повинен мати id, назву, ціну, опис. \n" +
                "Реалізація повинна мати id, дату, кількість. \n"
        );


        this.setVisible(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("Info");
        this.setResizable(false);


    }
}
