package model;

public class Timber {

    private Wood wood;
    private float length;
    private float width;
    private float height;

    public Timber(Wood wood, float length, float width, float height) {
        this.wood = wood;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Wood getWood() {
        return wood;
    }

    public void setWood(Wood wood) {
        this.wood = wood;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float volume() {
        return length * width * height;
    }

    public float weight() {
        return volume() * wood.getDensity();
    }

}
