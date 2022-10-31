package testsForWood;


import static org.junit.Assert.*;

import model.Wood;
import store.WoodDirectory;




public class testWood {
    public static void main(String[] args) {
        WoodDirectory wd = new WoodDirectory();
        wd.addWood(new Wood(3, "Maple", 900));
            assertEquals(4, wd.getWoods().length);
            assertEquals("Maple", wd.getWoodById(3).getName());
            assertEquals(900, wd.getWoodById(3).getDensity(), 0.001);
            assertEquals(0, wd.getWoodById(0).getId());
            assertEquals("Oak", wd.getWoodById(0).getName());
            assertEquals(1000, wd.getWoodById(0).getDensity(), 0.001);

    }

}
