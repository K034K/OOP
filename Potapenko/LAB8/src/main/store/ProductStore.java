package store;

import event.IProductListener;
import event.ProductEvent;
import model.IWeight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductStore extends AbstractStore {


    List<IProductListener> productListenerList = new CopyOnWriteArrayList<>();


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

    //event listeners

    public void addProductListener(IProductListener listener) {
        productListenerList.add(listener);
    }

    public void removeProductListener(IProductListener listener) {
        productListenerList.remove(listener);
    }

    protected void fireProductEvent(ProductEvent obj) {
        productListenerList.forEach(listener -> listener.onProductEvent(obj));
    }

    public void add(IWeight product) {
        super.add(product);
        fireProductEvent(new ProductEvent(this, product, System.currentTimeMillis()));
    }


}
