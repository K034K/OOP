package testsForWood;


import model.Cylinder;
import model.IWeight;
import model.Timber;
import model.Waste;
import store.ProductStore;
import store.WoodDirectory;

import javax.swing.*;

import java.util.Iterator;
import java.util.ListIterator;

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
        try {
            ps.add(new Timber(wd.getWoodById(0), 5, 0.4f, 0.2f));
            ps.add(new Timber(wd.getWoodById(1), 12, 0.5f, 0.2f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        assertEquals(2, ps.getCount());
        assertEquals(1300.0f, ps.calculateWeight(), 0.0001);
        assertEquals(400.0f, ((IWeight) ps.get()[0]).weight(), 0.001);
        assertEquals(900.0f, ((IWeight) ps.get()[1]).weight(), 0.001);

        //testing Cylinder
        try {
            ps.add(new Cylinder(wd.getWoodById(1), 0.5f, 4.0f));
            ps.add(new Cylinder(wd.getWoodById(2), 0.4f, 4.9f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        assertEquals(4, ps.getCount());
        float cyl1Weight = (float) (pow(0.5, 2) * Math.PI * 4.0f * wd.getWoodById(1).getDensity());
        float cyl2Weight = (float) (pow(0.4, 2) * Math.PI * 4.9f * wd.getWoodById(2).getDensity());
        assertEquals(cyl1Weight, ((IWeight) ps.get()[2]).weight(), 0.001);
        assertEquals(cyl2Weight, ((IWeight) ps.get()[3]).weight(), 0.001);
        assertEquals(1_300.0f + cyl1Weight + cyl2Weight, ps.calculateWeight(), 0.0001);


        //testing waste
        try {
            ps.add(new Waste(40));
            ps.add(new Waste(80));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        assertEquals(6, ps.getCount());
        assertEquals(1300.0f + cyl1Weight + cyl2Weight + 120, ps.calculateWeight(), 0.0001);

        System.out.println(ps);
        System.out.println("Total weight: " + ps.calculateWeight());
        System.out.println("Total count: " + ps.getCount());
        System.out.println("All tests are passed!");

        Iterator<Object> iter = ps.iterator();
        while (iter.hasNext()) {
            IWeight obj = (IWeight) iter.next();
            if (obj.weight() > 100) {
                iter.remove();
            }
        }

        System.out.println("After removing elements with weight > 100");
        System.out.println(ps.toString());
        ListIterator<Object> listIter = ps.listIterator();
        System.out.println("Output fist from product store");
        System.out.println(listIter.next());

    }
}
