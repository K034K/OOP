package store;

import model.Wood;

import java.util.Arrays;

public class WoodDirectory {
    private Wood[] woods = new Wood[3];
    private int count = 0;

    {
        woods[count++] = new Wood(0, "Oak", 1000);
        woods[count++] = new Wood(1, "Beech", 750);
        woods[count++] = new Wood(2, "Pine", 800);
    }

    public Wood[] getWoods() {
        return Arrays.copyOf(woods, count);
    }


    public Wood getWoodById(int id) {
        for (int i = 0; i < count; i++) {
            if (woods[i].getId() == id) {
                return woods[i];
            }
        }
        return null;

    }

    public boolean addWood(Wood wood) {
        if (getWoodById(wood.getId()) != null) { // check if wood with such id already exists
            return false;
        }
        if (count == woods.length) { // check if array is full
            woods = Arrays.copyOf(woods, count + count / 2);
        }
        woods[count++] = wood; // add wood to array
        return true;
    }

    public String toString() {
        return "WoodDirectory [woods=" + Arrays.toString(woods) + "]";
    }

}
