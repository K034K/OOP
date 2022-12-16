package testsForWood;

import javax.swing.*;
import java.io.File;

public class TestFile2 {

        public static void main(String[] args) {
            JFileChooser dialog = new JFileChooser();
            dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            dialog.setDialogTitle("Select a file or directory Mrynskyi");
            dialog.setApproveButtonText("Select");
            dialog.setMultiSelectionEnabled(true);
            dialog.showOpenDialog(null);
            File[] files = dialog.getSelectedFiles();
            if(files != null) {
                for(File file : files) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
}
