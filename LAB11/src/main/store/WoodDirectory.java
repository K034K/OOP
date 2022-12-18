package store;

import model.IWeight;
import model.Wood;

import java.util.*;


public class WoodDirectory extends AbstractStore {
    private Map<Integer, Object> map = new HashMap<>();

    {
        map.put(1, new Wood(0, "Дуб", 0.7f));
        map.put(2, new Wood(1, "Сосна", 0.4f));
        map.put(3, new Wood(2, "Береза", 0.5f));
    }

    public Wood getWoodById(int id) {
        return (Wood) map.get(id);
    }

    public boolean add(Wood wood) {
        if (map.containsKey(wood.getId())) {
            return false;
        }
        map.put(wood.getId(), wood);
        return true;
    }

    //Iterators

    @Override
    public Iterator<Object> iterator() {
        return map.values().iterator();
    }

    //getCount and get

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object[] get() {
        return map.values().toArray();
    }

}
