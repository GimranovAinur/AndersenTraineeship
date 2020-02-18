package andersen.course.custom_linkedlist;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CustomLinkedListTestCase {

    private CustomLinkedList<Integer> testList = new CustomLinkedList<Integer>();

    @Test
    public void testAddMethod() {
        CustomLinkedList<Integer> list = getTestData();
        list.add(500);
        assertThat(list.size(), equalTo(6));
    }

    @Test
    public void testAddByIndex() {
        CustomLinkedList<Integer> list = getTestData();
        list.add(500, 4);
        assertThat(list.get(4), equalTo(500));
    }

    @Test
    public void testAddByIndexToHead() {
        CustomLinkedList<Integer> list = getTestData();
        list.add(500, 0);
        assertThat(list.get(1), equalTo(-5));
    }

    @Test
    public void testClear() {
        CustomLinkedList<Integer> list = getTestData();
        list.clear();
        assertThat(list.size(), equalTo(0));
    }

    @Test
    public void testGetByIndex() {
        CustomLinkedList<Integer> list = getTestData();
        assertThat(list.get(1), equalTo(10));
    }

    @Test
    public void testGetByIndexOutOfBounds() {
        CustomLinkedList<Integer> list = getTestData();
        assertThat(list.get(10), equalTo(null));
    }

    @Test
    public void testRemove() {
        CustomLinkedList<Integer> list = getTestData();
        list.remove();
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void testRemoveElementByIndex() {
        CustomLinkedList<Integer> list = getTestData();
        assertThat(list.remove(3), equalTo(1000));
    }

    @Test
    public void testRemoveElementByIndexFromHead() {
        CustomLinkedList<Integer> list = getTestData();
        list.remove(0);
        assertThat(list.getFirst(), equalTo(10));
    }

    @Test
    public void testRemoveElementByIndexFromEnd() {
        CustomLinkedList<Integer> list = getTestData();
        list.remove(4);
        assertThat(list.getLast(), equalTo(1000));
    }

    @Test
    public void testRemoveElement() {
        CustomLinkedList<Integer> list = getTestData();
        list.remove(new Integer(300));
        assertThat(list.contains(300), equalTo(Boolean.FALSE));
    }

    @Test
    public void testRemoveElementFromHead() {
        CustomLinkedList<Integer> list = getTestData();
        list.remove(new Integer(-5));
        assertThat(list.getFirst(), equalTo(10));
    }

    @Test
    public void testRemoveElementFromEnd() {
        CustomLinkedList<Integer> list = getTestData();
        list.remove(new Integer(2000));
        assertThat(list.getLast(), equalTo(1000));
    }

    @Test
    public void testSize() {
        CustomLinkedList<Integer> list = getTestData();
        assertThat(list.size(), equalTo(5));
    }

    @Test
    public void testListReverse() {
        CustomLinkedList<Integer> list = getTestData();
        CustomLinkedList<Integer> reversedList = getReverseData();

        list.reverse();
        boolean equals = true;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(reversedList.get(i))) {
                equals = false;
                break;
            }
        }
        assertThat(equals, equalTo(Boolean.TRUE));
    }

    private CustomLinkedList<Integer> getTestData() {
        if (testList.isEmpty()) {
            testList.add(-5);
            testList.add(10);
            testList.add(300);
            testList.add(1000);
            testList.add(2000);
        }
        try {
            return (CustomLinkedList<Integer>) testList.clone();
        } catch (CloneNotSupportedException e) {
            return testList;
        }
    }

    private CustomLinkedList<Integer> getReverseData() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(2000);
        list.add(1000);
        list.add(300);
        list.add(10);
        list.add(-5);

        return list;
    }

}
