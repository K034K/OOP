package testsForWood;

import model.Wood;
import store.WoodDirectory;
import java.io.Serializable;

import java.io.*;

public class TestStoreObject {
    public static void main(String[] args) {
        WoodDirectory wd = new WoodDirectory();
        wd.add(new Wood(1, "Дуб", 1f));
        File file = new File("wd.object");
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wd);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
