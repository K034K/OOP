package store;

import model.Wood;


public class WoodDirectory  extends AbstractStore {

//    {
//        arr[0] = new Wood(0, "Oak", 1000);
//        arr[1] = new Wood(1, "Beech", 750);
//        arr[2] = new Wood(2, "Pine", 800);
//        count = 3;
//    }


    public Wood getWoodById(int id) {
        for (int i = 0; i < count; i++) {
            if (((Wood) arr[i]).getId() == id) {
                return (Wood) arr[i];
            }
        }
        return null;

    }

    public boolean add(Wood wood) {
        if (getWoodById(wood.getId()) != null) { // check if wood with such id already exists
            return false;
        }
        super.add(wood);
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("WoodDirectory: \n");
        result.append(super.toString());
        return result.toString();
    }

    {
        this.add(new Wood(0, "Oak", 1000));
        this.add(new Wood(1, "Beech", 750));
        this.add(new Wood(2, "Pine", 800));
    }
}
