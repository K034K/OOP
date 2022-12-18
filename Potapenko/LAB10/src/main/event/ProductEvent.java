package event;

import model.IWeight;

import java.util.EventObject;

public class ProductEvent extends EventObject {

    private IWeight product;
    private long time;

    public ProductEvent(Object source, IWeight product, long time) {
        super(source);
        this.product = product;
        this.time = time;
    }

    public IWeight getProduct() {
        return product;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return time%1000 + ": " + product;
    }


}
