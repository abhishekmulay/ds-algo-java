package datastructures;

/**
 * Created by Abhishek Mulay on 5/21/17.
 */
public class Stack <E> {

    private Node top;
    private int size = 0;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public <E> boolean push(E item) {
        boolean result = false;
        if (this.size() == 0) {
//            Node<E> node = new Node<E>(element, null);
            Node<E> node = createNode(item);
            this.top = node;
        }
        return result;
    }

    public int size() {
        return this.size;
    }

    private <E> Node<E> createNode(E data) {
        return new Node<E>(data, null);
    }
}
