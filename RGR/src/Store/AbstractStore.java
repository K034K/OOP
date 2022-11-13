package Store;

import entitys.entity;

public class AbstractStore {

    private entity[] abstractStoreArray = new entity[0];

    public AbstractStore(Object entity) {
        super();
    }

    public void add (entity entityProvided) {
        entity[] newAbstractStoreArray = new entity[abstractStoreArray.length + 1];
        System.arraycopy(abstractStoreArray, 0, newAbstractStoreArray, 0, abstractStoreArray.length);
        int lastIndex = newAbstractStoreArray.length - 1;
        newAbstractStoreArray[lastIndex] = entityProvided;
        abstractStoreArray = newAbstractStoreArray;
    }


    public entity[] getAll () {
        return abstractStoreArray;
    }

    public entity get (int index) {
        return abstractStoreArray[index];
    }

    public int size () {
        return abstractStoreArray.length;
    }

    public void update (int index, entity entity) {
        abstractStoreArray[index] = entity;
    }




}
