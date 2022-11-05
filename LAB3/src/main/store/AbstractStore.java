package store;

import model.AbstarctForm;

import java.util.Arrays;

public abstract class AbstractStore {
    protected Object[] arr = new Object[3];

    protected int count = 0;

    protected void add(Object product) {
        if (count == arr.length) {
            arr = Arrays.copyOf(arr, count + count / 2);
        }
        arr[count++] = product;
    }

    public Object[] get() {
        return Arrays.copyOf(arr, count);
    }

    public int getCount() {
        return count;
    }


    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(arr[i].toString()).append("\n");
        }
        return result.toString();
    }

}
