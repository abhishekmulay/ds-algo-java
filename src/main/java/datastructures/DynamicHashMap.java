package datastructures;

/**
 * Created by Abhishek Mulay on 5/26/17.
 */
public class DynamicHashMap<T> {

    private final int DEFAULT_SIZE = 16;
    private DynamicArray<DynamicArray<T>> dataList = new DynamicArray<DynamicArray<T>>(DEFAULT_SIZE);

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public DynamicHashMap(int initialSize) {
        this.dataList = new DynamicArray<DynamicArray<T>>(initialSize);
    }

//    public <K, V extends Comparable<? super V>>  boolean put(K key, V value) {
//        int hashCode = key.hashCode();
//        int index = hashCode / (this.dataList.size()-1);
//
//        if (this.dataList.get(index) == null) {
//            DynamicArray<T extends Comparable> newBucket = new DynamicArray<T>();
//            newBucket.add(value, 0);
//            this.dataList.add(newBucket, index);
//        } else {
//            DynamicArray<Node> previousBucket = this.dataList.get(index);
//            previousBucket.add();
//        }
//    }

}
