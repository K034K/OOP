package model;

public class Cylinder extends AbstractForm {
    private float radius;
    private float height;


    public Cylinder(Wood wood, float radius, float height)throws Exception {
        super(wood);
        setRadius(radius);
        setHeight(height);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius)throws Exception {
        if(radius < 0.1f || radius > 10.5f){
            throw new Exception(radius + " is not a valid radius for cylinder" +
                    " (must be between 0.2 and 0.5)");
        }
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height)throws Exception {
        if(height < 0.2f || height > 100.0f){
            throw new Exception(height + " is not a valid height for cylinder" +
                    " (must be between 0.2 and 0.5)");
        }
        this.height = height;
    }

    public float volume() {
        return (float) (Math.PI * Math.pow(radius, 2) * height);
    }

    public String toString() {
        return "Cylinder: " + wood + ", radius: " + radius + ", height: " + height;
    }
}

