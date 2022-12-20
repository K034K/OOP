package entitys;

public class Product extends entity{

    private String description;
    private double price;

    //constructor


    public Product(int id, String name, String description, double price) {
        super(id, name);
        this.description = description;
        this.price = price;
    }

    //getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
