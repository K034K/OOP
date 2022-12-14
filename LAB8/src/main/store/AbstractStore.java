package store;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class AbstractStore implements Iterable<Object>{
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
        for(Object obj : arr) {
            result.append(obj);
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count && arr[currentIndex] != null;
            }

            @Override
            public Object next() {
                return arr[currentIndex++];
            }

            @Override
            public void remove() {
                System.arraycopy(arr, currentIndex, arr, currentIndex - 1, count-- - currentIndex--);
            }
        };
    }

    //Iterator implementation

    private class StoreIterator implements Iterator<Object> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count && arr[currentIndex] != null;
        }

        @Override
        public Object next() {
            return arr[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    //ListIterator implementation

    private class StoreListIterator implements ListIterator<Object> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count && arr[currentIndex] != null;
        }

        @Override
        public Object next() {
            return arr[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public Object previous() {
            return arr[--currentIndex];
        }

        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void set(Object o) {
            arr[currentIndex] = o;
        }

        @Override
        public void add(Object o) {
            throw new UnsupportedOperationException();
        }
    }

    //create list iterator and return it

    public ListIterator<Object> listIterator() {
        return new StoreListIterator();
    }

}
