package entitys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Realization extends entity{
    private int quantity;
    private double price;

    public Realization(int id, int quantity, double price) {
        super(id, null);
        this.quantity = quantity;
        this.price = price;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String getName(){

        return null;
    }

    @Override
    public void setName(String name) {
    }
    @Override
    public String toString() {
        return "Realization{" +
                "quantity=" + quantity +
                ", price=" + price +

                '}';
    }

}
