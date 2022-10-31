package store;

import model.Timber;


import java.util.Arrays;

public class ProductStore {
    private Timber[] products = new Timber[3];

    private int count = 0;

    public void add(Timber timber) {
        if (count == products.length) {
            products = Arrays.copyOf(products, count + count / 2);
        }
        products[count++] = timber;
    }

    public Timber[] getProducts() {
        return Arrays.copyOf(products, count);
    }

    public int getProductsCount() {
        return count;
    }

    public float calculateWeight() {
        float weight = 0;
        for (int i = 0; i < count; i++) {
            weight += products[i].weight();
        }
        return weight;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < count; i++) {
            if (products[i] instanceof Timber) {
                result += "Timber Wood: " + products[i].getWood().getName() + " Volume of " + products[i].volume() + "\n";
            }
        }
        return result;
    }

}
