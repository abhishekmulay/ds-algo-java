package datastructures;

/**
 * Created by Abhishek Mulay on 5/21/17.
 */
public class DoublyLinkedList<T> {
    private static class Node<T> {
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

    public DoublyLinkedList() {
    }

    public int size() {
        return this.size;
    }

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
            node.setNext(this.head);
            this.head.setPrevious(node);
            this.tail = node;
            this.size++;
            this.tail = node;
        }
        return result;
    }

    public <T> boolean remove(T dataToRemove) {
        if (dataToRemove == null)
            throw new IllegalArgumentException("Can not remove null");

//        int position = this.indexOf(dataToRemove);
//        if (position == -1)
//            return false;

        int index = 0;
        Node pointer = this.head;
        while (pointer.getNext() != this.tail) {
            if (pointer.getData() == dataToRemove) {
                Node nextNode = pointer.getNext();
                Node previousNode = pointer.getPrevious();

                previousNode.setNext(nextNode);
                nextNode.setPrevious(previousNode);
                pointer = null;
                this.size -= 1;
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }

    public <T> int indexOf(T searchValue) {
        if (this.size() == 1) {
            return this.head.getData() == searchValue ? 1 : -1;

        } else {
            Node pointer = this.head;
            int index = 0;
            while (pointer != null) {
                if (pointer.getData() == searchValue) {
                    return index;
                }
                pointer = pointer.getNext();
                index++;
            }
        }
        return -1;
    }

    public <T> boolean contains(T data) {
        return this.indexOf(data) > -1;
    }

    private <T> Node<T> createNode(T data) {
        return new Node<T>(data, null, null);
    }

    static <T> boolean dataEquals(T data1, T data2) {
        boolean result = false;
        if (data1 == null || data2 == null)
            throw new IllegalArgumentException("One or more arguments are null.");
        else if (data1 instanceof Integer && data2 instanceof Integer)
            result = data1 == data2;
        else if (data1 instanceof String && data2 instanceof String)
            result = data1.equals(data2);
        return result;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        output.append("DoublyLinkedList {");
        Node pointer = this.head;
        int total = this.size();

        while (true) {
            output.append(pointer.getData());
            if (total == 1) {
                output.append("}");
                return output.toString();
            }
            output.append(", ");
            pointer = pointer.getNext();
            total -= 1;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        doublyLinkedList.add("A");
        doublyLinkedList.add("B");
        doublyLinkedList.add("C");
        System.out.println(doublyLinkedList);
        int index = doublyLinkedList.indexOf("A");
        doublyLinkedList.remove("A");
        System.out.println(index);
        System.out.println(doublyLinkedList);
    }
}
