package testsForWood;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f != null) {

                    return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");

                }
                return false;
            }

            @Override
            public String getDescription() {
                return "Text files";
            }
        });

        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
        }

        try{
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
            for (int i = 0; i < 10; i++) {
                double x = Math.random();
                String s = String.valueOf(x);
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader reader = null;
        if (file != null) {
            try {
                reader = new BufferedReader(new java.io.FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}



