package model;

public class Timber extends AbstractForm {

    private float length;
    private float width;
    private float height;

    public Timber(Wood wood, float length, float width, float height) throws Exception {
        super(wood);
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length)throws Exception {
        if(length < 0.2f || length > 300.0f){
            throw new Exception(length + " is not a valid length for timber" +
                    " (must be between 0.2 and 5.0)");
        }

        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width)throws Exception {
        if(width < 0.2f || width > 0.5f){
            throw new Exception(width + " is not a valid width for timber" +
                    " (must be between 0.2 and 0.5)");
        }
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height)throws Exception {
        if(height < 0.2f || height > 0.5f){
            throw new Exception(height + " is not a valid height for timber" +
                    " (must be between 0.2 and 0.5)");
        }
        this.height = height;
    }

    public float volume() {
        return length * width * height;
    }

    public String toString() {
        return "Timber: " + wood + ", length: " + length + ", width: " + width + ", height: " + height;
    }

}
