package store;

import model.AbstractForm;
import model.IWeight;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class AbstractStore implements  Collection<Object>, Serializable {

    private final List<Object> list = new ArrayList<Object>();



    public boolean add(Object obj) {
        list.add(obj);
        return true;
    }

    public abstract Object[] get();

    public int getCount() {
        return list.size();
    }


    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Object obj : list) {
            result.append(obj.toString());
            result.append("\n");

        }
        return result.toString();
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    //listeners

}
