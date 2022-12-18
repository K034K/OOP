package entitys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Realization extends entity{
    private int quantity;
    private int price;
    private String date;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private LocalDateTime now = LocalDateTime.now();

    public Realization(int id, int quantity, int price, LocalDateTime date) {
        super(id, null);
        this.quantity = quantity;
        this.price = price;
        this.date = dtf.format(now);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
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
                ", date=" + date +
                '}';
    }

}
