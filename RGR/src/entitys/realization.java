package entitys;

import javax.xml.crypto.Data;
import java.util.Date;

public class realization extends entity{
    private int quantity;
    private int price;
    private Date date;



    public realization(int id, int quantity, int price, Date date) {
        super(id, null);
        this.quantity = quantity;
        this.price = price;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getName(){

        return null;
    }

    @Override
    public void setName(String name) {
    }

}
