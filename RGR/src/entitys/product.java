package entitys;

public class product extends entity{

    private String description;
    private int price;

    //constructor


    public product(int id, String name, String description, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
