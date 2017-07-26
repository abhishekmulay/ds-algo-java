package datastructures;

/**
 * Created by Abhishek Mulay on 6/2/17.
 */
public class SinglyLinkedList <E>{

    private int size = 0;
    private Node<E> head;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public SinglyLinkedList() {

    }

    public void add(E data) {
        if (data == null)
            throw new IllegalArgumentException("Can not insert null value in list.");

        // list is empty, adding first node
        if (this.size() == 0) {
            Node<E> newNode = new Node<E>(data, null);
            this.head = newNode;
        } else {
            // list already contains nodes, add at end
            Node pointer = this.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            Node<E> newNode = new Node<E>(data, null);
            pointer.next = newNode;
        }
        this.size += 1;
    }

    public int size() {
        return this.size;
    }

    public E remove(E dataToRemove) {
        Node<E> pointer = this.head;
        Node<E> previous = this.head;
        E deletedValue = null;

        // delete head and move head to next
        if (this.head.data == dataToRemove) {
            this.head = this.head.next;
            this.size -= 1;
            return this.head.data;
        }

        while (pointer != null) {
            // found node to delete
            if (pointer.data == dataToRemove) {
                deletedValue = pointer.data;
                previous.next  = pointer.next;
                this.size -= 1;
                return deletedValue;
            }

            previous = pointer;
            pointer = pointer.next;
        }
        throw new IllegalArgumentException("Data not present in list");
    }

    public boolean contains (E data) {
        return indexOf(data) != -1;
    }

    public int indexOf(E data) {
        int index = -1;
        Node<E> pointer = this.head;
        while (pointer.next != null) {
            if (pointer.data == data)
                return index;

            index += 1;
            pointer = pointer.next;
        }

        // not found, will return -1
        return index;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SinglyLinkedList {");

        int count = this.size();
        Node<E> pointer = this.head;
        while (true) {
            E data = pointer.data;
            if (count == 1) {
                buffer.append(data).append("}");
                return buffer.toString();
            }
            buffer.append(data).append(',');
            count-=1;
            pointer = pointer.next;
        }
    }

    public static <E> SinglyLinkedList<E> reverseList(SinglyLinkedList<E> list, int count) {
        // base case
        if (count == 1)
            return list;

        // first
        Node<E> first = list.head;
        // rest
        list.remove(first.data);
        // add at end
        list.add(first.data);
        // recur
        count--;
        return reverseList(list, count);
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);
        reverseList(list, list.size());
        System.out.println(list);
    }
}
