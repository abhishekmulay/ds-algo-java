package datastructures;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Abhishek Mulay on 5/12/17.
 */
public class DynamicArrayTest extends TestCase {

    @Test
    public void testObjectCreation() {
        DynamicArray<String> arr= new DynamicArray();
        assertNotNull(arr);
        assertNotNull(new DynamicArray(20));
    }

    @Test
    public void testAddOperation() {
        DynamicArray<String> arr = new DynamicArray();;
        int previousLength = arr.size();
        String testData = "TEST";
        arr.add(testData, 0);
        int afterLength = arr.size();
        Assert.assertEquals("should insert element at 0th position",arr.get(0), testData);
        Assert.assertEquals(previousLength +1 , afterLength);
    }

    @Test
    public void testAddOperationExceedingBounds() {
        int beforeSize = 0;
        int afterSize = 0;

        DynamicArray<String> arr = new DynamicArray(10);
        String data = "";
        for (int i=0; i < 50; i++) {
            beforeSize = arr.size();
            data = "" +i*10;
            arr.add(data, i);
            afterSize = arr.size();
            Assert.assertEquals( "size should increase",beforeSize+1, afterSize);
            Assert.assertEquals("should insert at " + i +"th position", arr.get(i), data);
        }
    }

    @Test
    public void testRangeCheck() {
        int index = 16;
        DynamicArray<String> arr = new DynamicArray(10);
        Assert.assertFalse(arr.rangeCheck(16));
        Assert.assertTrue(arr.rangeCheck(1));
    }

    @Test
    public void testContain() {
        DynamicArray<String> arr = new DynamicArray(10);
        String testData = "Wubba Lubba Dub Dub";
        Assert.assertFalse(arr.contains(testData));
        arr.add(testData, 0);
        Assert.assertTrue(arr.contains(testData));
    }

    @Test
    public void testAddAtEnd() {
        DynamicArray<String> arr = new DynamicArray(10);
        String testData1 = "A";
        String testData2 = "B";
        arr.add(testData1);
        arr.add(testData2);
        Assert.assertEquals("Should add at the end. ", arr.get(1), testData2);
    }

    @Test
    public void testRemove() {
        DynamicArray<String> arr = new DynamicArray(10);
        String testData = "A";
        arr.add(testData);
        int beforeRemove = arr.size();
        arr.remove(0);
        int afterRemove = arr.size();
        Assert.assertEquals("size should remain same ", beforeRemove, afterRemove + 1);
        Assert.assertFalse("should be removed from array ", arr.contains(testData));
    }
}