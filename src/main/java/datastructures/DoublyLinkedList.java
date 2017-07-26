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

        if (this.size() == 1 && this.head.getData() == dataToRemove) {
            this.head = null;
            this.tail = null;
            this.size -= 1;
            return true;
        }

        else if (this.head.getData() == dataToRemove) {
            Node nextNode = this.head.getNext();
            Node previousNode = this.head.getPrevious();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
            this.head = nextNode;
            this.size -= 1;
            return true;
        }

        else if (this.tail.getData() == dataToRemove) {
            Node nextNode = this.tail.getNext();
            Node previousNode = this.tail.getPrevious();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
            this.tail = previousNode;
            this.size -= 1;
            return true;
        }

        int index = 0;
        Node pointer = this.head;
        while (pointer != this.tail) {
            if (pointer.getData() == dataToRemove) {
                Node nextNode = pointer.getNext();
                Node previousNode = pointer.getPrevious();

                previousNode.setNext(nextNode);
                nextNode.setPrevious(previousNode);
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

            if (this.head.getData() == searchValue) return 0;
            if (this.tail.getData() == searchValue) return this.size();

            Node pointer = this.head;
            int index = 0;
            while (pointer.getNext() != this.tail) {
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
}
