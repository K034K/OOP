package store;

import event.IProductListener;
import model.Cylinder;
import model.IWeight;
import model.Timber;
import model.Waste;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductStore extends AbstractStore {


    private List<Object> list = new ArrayList<>();

    List<IProductListener> productListenerList = new CopyOnWriteArrayList<>();


    public float calculateWeight() {
        float weight = 0;

        for (Object obj : list) {
            if (obj instanceof IWeight) {
                weight += ((IWeight) obj).weight();
            }
        }

        return weight;
    }

    //if products are the same, then add quantity
    //first are going cylinders then timber and last waste
    //

    //sort hashmaps by key if cylinder then timber then waste
    private Map<Object, Integer> sort(Map<Object, Integer> map) {
        Map<Object, Integer> cylinderMap = new LinkedHashMap<>();
        Map<Object, Integer> timberMap = new LinkedHashMap<>();
        Map<Object, Integer> wasteMap = new LinkedHashMap<>();
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (entry.getKey() instanceof Cylinder) {
                cylinderMap.put(entry.getKey(), entry.getValue());
            } else if (entry.getKey() instanceof Timber) {
                timberMap.put(entry.getKey(), entry.getValue());
            } else if (entry.getKey() instanceof Waste) {
                wasteMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<Object, Integer> newmap = new LinkedHashMap<>();
        newmap.putAll(cylinderMap);
        newmap.putAll(timberMap);
        newmap.putAll(wasteMap);
        return newmap;
    }

    //sort hashmap

    private void compareHashMapKeys(Object obj, Map<Object, Integer> map) {

        if(obj instanceof Cylinder cylinder) {
            for (Object o : map.keySet()) {
                if (o instanceof Cylinder cylinder1) {
                    if (cylinder.getWood().equals(cylinder1.getWood()) && cylinder.getRadius() == cylinder1.getRadius() && cylinder.getHeight() == cylinder1.getHeight()) {
                        map.put(cylinder1, map.get(cylinder1) + 1);
                        return;
                    }
                }
            }
            map.put(cylinder, 1);
        }else if(obj instanceof Timber timber) {
            for (Object o : map.keySet()) {
                if (o instanceof Timber timber1) {
                    if (timber.getWood().equals(timber1.getWood()) && timber.getWidth() == timber1.getWidth() && timber.getHeight() == timber1.getHeight() && timber.getLength() == timber1.getLength()) {
                        map.put(timber1, map.get(timber1) + 1);
                        return;
                    }
                }
            }
            map.put(timber, 1);
        }else if(obj instanceof Waste waste) {
            for (Object o : map.keySet()) {
                if (o instanceof Waste waste1) {
                    if (waste.getWeight() == waste1.getWeight()) {
                        map.put(waste1, map.get(waste1) + 1);
                        return;
                    }
                }
            }
            map.put(waste, 1);
        }
        else map.put(obj, 1);

    }

    // compare products parameters and add quantity
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Products:\n");
        Map<Object, Integer> map = new HashMap<>();
        for (Object obj : list) {
            compareHashMapKeys(obj, map);
        }
        map = sort(map);
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            result.append(entry.getKey().toString());
            result.append(" quantity: ");
            result.append(entry.getValue());
            result.append("\n");
        }
        return result.toString();
    }

    public boolean add(IWeight product) {
        list.add(product);
        return true;
    }

    //Iterators

    @Override
    public Iterator<Object> iterator() {
        return list.iterator();
    }


    //getCount and get

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object[] get() {
        return list.toArray();
    }

    public void addProductListener(IProductListener listener) {
        productListenerList.add(listener);
    }

    public void removeListener(IProductListener listener) {
        productListenerList.remove(listener);
    }
}
