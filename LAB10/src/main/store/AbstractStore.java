package store;

import model.AbstractForm;
import model.IWeight;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class AbstractStore implements Iterable<Object>, Serializable, Collection<Object> {

    private final List<Object> list = new ArrayList<Object>();
    protected Object[] arr = new Object[3];

    protected int count = 0;


    public boolean add(Object obj) {
        list.add(obj);
        return true;
    }

    public Object[] get() {
        return Arrays.copyOf(arr, count);
    }

    public int getCount() {
        return count;
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

    //crete remove method
    public void remove(Predicate<Object> predicate) {
        Iterator<Object> iterator = this.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (predicate.test(obj)) {
                iterator.remove();
            }
        }
    }

    public void doForAll(Consumer<Object> consumer) {
        Iterator<Object> iterator = this.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            consumer.accept(obj);
        }
    }

    public void doOnlyFor(Consumer<Object> consumer, float maxWeight) {
        Iterator<Object> iterator = this.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (((IWeight) obj).weight() > maxWeight) {
                consumer.accept(obj);
            }
        }
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


}
