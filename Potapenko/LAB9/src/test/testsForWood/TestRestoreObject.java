package testsForWood;

import store.WoodDirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestRestoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = null;
        File file = new File("wd.object");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wd = (WoodDirectory) ois.readObject();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(wd != null) {
           for(Object w: wd.get()) {
               System.out.println(w.toString());
           }
        }
    }
}
