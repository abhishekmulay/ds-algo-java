package datastructures;

/**
 * Created by Abhishek Mulay on 5/21/17.
 */
public class DoublyLinkedList<T> {
    private static class Node <T> {
        T data;
        Node next;
        Node previous;

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    // pointers
    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedList() {}

    public <T> boolean add(T data) {
        // list is empty
        boolean result = false;
        if (size == 0) {
            Node<T> node = createNode(data);
            this.head = node;
            this.tail = node;
            this.size++;
            result = true;
        } else {
            Node lastNode = this.tail;
            Node<T> node = createNode(data);
            lastNode.setNext(node);
            node.setPrevious(lastNode);
            this.size++;
            this.tail = node;
        }
        return result;
    }

    private <T> Node<T> createNode(T data) {
        return new Node<T>(data, null, null);
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        output.append("DoublyLinkedList {");
        Node pointer = this.head;

        while (true) {
            output.append(pointer.getData());
            if (pointer.getNext() == null) {
                output.append("}");
                return output.toString();
            }
            output.append(", ");
            pointer = pointer.getNext();
        }
    }

    public int size() {
        return this.size;
    }


    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        doublyLinkedList.add("A");
        doublyLinkedList.add("B");
        doublyLinkedList.add("C");
        System.out.println(doublyLinkedList);
    }
}
