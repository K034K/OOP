package model;

public class Waste implements IWeight {
    private float weight;

    public Waste(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }



    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public float weight() {
        return weight;
    }
}

