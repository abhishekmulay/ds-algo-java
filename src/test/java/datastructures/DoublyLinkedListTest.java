package datastructures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Abhishek Mulay on 5/21/17.
 */
public class DoublyLinkedListTest {

    DoublyLinkedList<String> doublyLinkedList = null;

    @Test
    public void add() throws Exception {
        doublyLinkedList = new DoublyLinkedList();
        int sizeBeforeAdd = doublyLinkedList.size();
        doublyLinkedList.add("A");
        int sizeAfterAdd= doublyLinkedList.size();
        doublyLinkedList.add("B");
        doublyLinkedList.add("C");
        int sizeAfterAddingThreeItems = doublyLinkedList.size();
        Assert.assertEquals("Size should increase by 1 after adding new data", sizeAfterAdd, sizeBeforeAdd + 1);
        Assert.assertEquals("Size should increase by 1 after adding new data", 3, sizeAfterAddingThreeItems);
    }

    @Test
    public void size() throws Exception {
        doublyLinkedList = new DoublyLinkedList<String>();
        int sizeAtStart = doublyLinkedList.size();
        Assert.assertEquals("Size at beginning should be 0 ", 0, sizeAtStart);

        doublyLinkedList.add(1);
        int sizeAfterAddingOneItem = doublyLinkedList.size();
        Assert.assertEquals("Size should increase by 1 after adding new data ", 1, sizeAfterAddingOneItem);
    }

}