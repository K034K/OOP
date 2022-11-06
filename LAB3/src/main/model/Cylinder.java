package model;

public class Cylinder extends AbstractForm {
    private float radius;
    private float height;


    public Cylinder(Wood wood, float radius, float height) {
        super(wood);
        this.radius = radius;
        this.height = height;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float volume() {
        return (float) (Math.PI * Math.pow(radius, 2) * height);
    }

    public String toString() {
        return "Cylinder: " + wood + ", radius: " + radius + ", height: " + height;
    }
}

