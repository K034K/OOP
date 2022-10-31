package testsForWood;


import model.Timber;
import store.ProductStore;
import store.WoodDirectory;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class testApp {

    private WoodDirectory wd = new WoodDirectory();
    private ProductStore ps = new ProductStore();


    public static void main(String[] args) {
        testApp app = new testApp();
        app.startApp();
        }
    private void startApp() {
        ps.add(new Timber(wd.getWoodById(0), 5, 0.4f, 0.2f));
        ps.add(new Timber(wd.getWoodById(1), 12, 0.5f, 0.2f));
        assertEquals(2, ps.getProductsCount());
        assertEquals(1300.0f, ps.calculateWeight(), 0.0001);
        assertEquals(400.0f, ps.getProducts()[0].weight(), 0.001);
        assertEquals(900.0f, ps.getProducts()[1].weight(), 0.001);
    }
}
