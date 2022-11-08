package model;

public abstract class AbstarctForm implements IWeight {
    protected Wood wood;



    public AbstarctForm(Wood wood) {
        this.wood = wood;
    }

    public Wood getWood() {
        return wood;
    }

    public void setWood(Wood wood) {
        this.wood = wood;
    }

    @Override
    public float weight() {
        return volume() * wood.getDensity();
    }

    public abstract float volume();

}
