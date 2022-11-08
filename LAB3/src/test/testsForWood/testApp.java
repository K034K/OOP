package testsForWood;


import model.Cylinder;
import model.IWeight;
import model.Timber;
import model.Waste;
import store.ProductStore;
import store.WoodDirectory;

import static java.lang.Math.pow;
import static org.junit.Assert.assertEquals;

public class testApp {

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();


    public static void main(String[] args) {
        testApp app = new testApp();
        app.startApp();
    }

    private void startApp() {

        //testing Timber
        ps.add(new Timber(wd.getWoodById(0), 5, 0.4f, 0.2f));
        ps.add(new Timber(wd.getWoodById(1), 12, 0.5f, 0.2f));
        assertEquals(2, ps.getCount());
        assertEquals(1300.0f, ps.calculateWeight(), 0.0001);
        assertEquals(400.0f, ((IWeight) ps.get()[0]).weight(), 0.001);
        assertEquals(900.0f, ((IWeight) ps.get()[1]).weight(), 0.001);

        //testing Cylinder
        ps.add(new Cylinder(wd.getWoodById(1), 0.5f, 4.0f));
        ps.add(new Cylinder(wd.getWoodById(2), 0.4f, 5.0f));
        assertEquals(4, ps.getCount());
        float cyl1Weight = (float) (pow(0.5, 2) * Math.PI * 4.0f * wd.getWoodById(1).getDensity());
        float cyl2Weight = (float) (pow(0.4, 2) * Math.PI * 5.0f * wd.getWoodById(2).getDensity());
        assertEquals(cyl1Weight, ((IWeight) ps.get()[2]).weight(), 0.001);
        assertEquals(cyl2Weight, ((IWeight) ps.get()[3]).weight(), 0.001);
        assertEquals(1_300.0f+cyl1Weight+cyl2Weight, ps.calculateWeight(), 0.0001);


        //testing waste
        ps.add(new Waste(100));
        ps.add(new Waste(200));
        assertEquals(6, ps.getCount());
        assertEquals(1300.0f+cyl1Weight+cyl2Weight+300, ps.calculateWeight(), 0.0001);


    }
}
