package store;

import model.IWeight;
import model.Wood;

import java.util.LinkedHashSet;
import java.util.Set;


public class WoodDirectory extends AbstractStore {

    Set<Object> set = new LinkedHashSet<Object>();

    public Wood getWoodById(int id) {
        for (int i = 0; i < count; i++) {
            if (((Wood) arr[i]).getId() == id) {
                return (Wood) arr[i];
            }
        }
        return null;

    }

//write add to list function
    public boolean add(IWeight product) {
        set.add(product);
        return true;
    }

    public String toString() {
        return "Wood Directory: \n" +
                set.toString().replace("[", "").replace("]", "").replace(",", "\n");
    }

    {
        set.add(new Wood(1, "Oak", 0.5f));
        set.add(new Wood(2, "Birch", 0.4f));
        set.add(new Wood(3, "Pine", 0.3f));
    }
}
