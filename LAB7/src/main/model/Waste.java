package model;

public class Waste implements IWeight {
    private float weight;

    public Waste(float weight) throws Exception {
        super();
        setWeight(weight);
    }

    public float getWeight() {
        return weight;
    }


    public void setWeight(float weight) throws Exception {
        if (weight < 20 || weight > 300) {
            throw new Exception(weight + " is not a valid weight for waste" +
                    " (must be between 20 and 100)");
        }
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

