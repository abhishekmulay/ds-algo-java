package datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Abhishek Mulay on 5/12/17.
 */
public class DynamicArray<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private T[] data = null;
    private int size = 0;

    // constructors
    public DynamicArray() {
        this.data = (T[]) Array.newInstance(Object.class, DEFAULT_INITIAL_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        this.data = (T[]) Array.newInstance(Object.class, DEFAULT_INITIAL_CAPACITY);
    }

    public void add(T data) {
        // add at end
        this.add(data, this.size());
    }

    public void add(T data, int index) {
        if (!rangeCheck(index)) {
            this.data = this.expandArray(this.data);
            System.out.println("Expanded array:" + this.data);
        }
        this.data[index] = data;
        this.size += 1;
    }

    private T[] expandArray(T[] data) {
        int currentCpacity = this.size();
        int doubleCapacity = currentCpacity * 2;
        T[] expandedArray = (T[]) Array.newInstance(Object.class, doubleCapacity);
        System.arraycopy(this.data, 0, expandedArray, 0, currentCpacity);
        return expandedArray;
    }

    public T get(int index) {
        return this.data[index];
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        if (!rangeCheck(index)) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        T valueToRemove = this.get(index);
        int length = this.data.length - index - 1;
        System.arraycopy(this.data, index + 1, this.data, index, length);
        this.size -= 1;
    }

    public int indexOf(T value) {
        int size = size();
        for (int index = 0; index < size; index++) {
            if (this.data[index].equals(value))
                return index;
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }


    public boolean rangeCheck(int newPosition) {
        return newPosition < (this.data.length - 1) && newPosition > -1;
    }

    @Override
    public String toString() {
        return "{size=" + size + ", data=" + Arrays.toString(data) + '}';
    }
}