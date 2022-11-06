package store;

import model.IWeight;

public class ProductStore extends AbstractStore {


    public void add(IWeight product) {
        super.add(product);
    }

    public float calculateWeight() {
        float weight = 0;
        for (int i = 0; i < count; i++) {
            weight += ((IWeight) arr[i]).weight();
        }
        return weight;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ProductStore: \n");
        result.append(super.toString());
        return result.toString();
    }

}
