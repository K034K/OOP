package model;

public class Timber extends AbstarctForm {

    private float length;
    private float width;
    private float height;

    public Timber(Wood wood, float length, float width, float height) {
        super(wood);
        this.length = length;
        this.width = width;
        this.height = height;
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

    public String toString() {
        return "Timber: " + wood + ", length: " + length + ", width: " + width + ", height: " + height;
    }

}
