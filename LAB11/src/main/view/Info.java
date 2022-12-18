package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Info extends JFrame {
    private JPanel mainPanel;
    private JTextArea programDeveloper;

    private URL url = Info.class.getResource("/developer.jpg");

    private BufferedImage img ;

    {
        try {
            assert url != null;
            img = javax.imageio.ImageIO.read(url);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(java.awt.Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        Image scaledImage = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        g2.drawImage(scaledImage, 0, 0, this);}



    public Info() {
        super("Info");
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Info");
        this.setResizable(false);



    }
}
