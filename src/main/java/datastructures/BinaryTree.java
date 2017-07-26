package datastructures;


/**
 * Created by Abhishek Mulay on 6/19/17.
 */
public class BinaryTree <E> {
    private static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left = null;
        Node<E> right = null;

        Node(E element) {
            this.element = element;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node<E> root = null;

    public Node<E> createTree(E[] items) {
        Node<E> parent = null; // root node

        for (int index=0; (2*index) < items.length; index++) {

            Node<E> left = null;
            Node<E> right = null;
            int leftIndex = (2 * index) + 1;
            int rightIndex = (2 * index) + 2;

            if (leftIndex < items.length) {
                left = new Node<E>(items[leftIndex]);
            }

            if (rightIndex < items.length) {
                right = new Node<E>(items[rightIndex]);
            }

            Node<E> current = new Node<E>(items[index]);

            current.setLeft(left);
            current.setRight(right);
            current.setParent(parent);

            System.out.println("current : " + (current == null ? "null" : ""+ current.element) +
                                ", left=" + (left == null ? "null" : ""+ left.element) +
                                ", right=" + (right == null ? "null" : ""+ right.element) +
                                ", parent=" + (parent == null ? "null" : ""+ parent.element));
            parent = current;

            if (index == 0) {
                root = current;
            }
        }
        System.out.println(root);
        return root;
    }


    @Override
    public String toString() {
        inOrder(root);
        return "";
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree();
        String [] data = {"a", "b", "c", "d", "e", "f", "g", "h"};
        tree.createTree(data);
        System.out.println(tree);
    }

}
