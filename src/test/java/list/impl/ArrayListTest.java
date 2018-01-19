package list.impl;

import list.ListInterface;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayListTest {

	@Test
	public void isEmpty() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		boolean expected = false;
		boolean actual = list.isEmpty();
		assertTrue (expected == actual);
	}

	@Test
	public void isNotEmpty() {
		ListInterface list = new ArrayList();
		boolean expected = true;
		boolean actual = list.isEmpty();
		assertTrue (expected == actual);
	}

	@Test
	public void subList() {
		Object[] elements = {1,3,5,7,8};
		Object[] subs = {3,5,7};
		ListInterface list = new ArrayList(elements);
		ListInterface expected = new ArrayList(subs);
		ListInterface actual = list.subList(1,3);
		assertTrue (expected.equals(actual));
	}

	@Test
	public void get() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		Object expected = 1;
		Object actual = list.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void size() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		int expected = 3;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void notEquals() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		Object[] another = {1,2};
		ListInterface newList = new ArrayList(another);
		boolean expected = false;
		boolean actual = list.equals(newList);
		assertTrue(expected == actual);
	}

	@Test
	public void equals() {
		Object[] elements = {1,2};
		ListInterface list = new ArrayList(elements);
		Object[] another = {1,2};
		ListInterface newList = new ArrayList(another);
		boolean expected = true;
		boolean actual = list.equals(newList);
		assertTrue(expected == actual);
	}

	@Test
	public void toArray() {
		Object[] expected = {1,3,4};
		ListInterface list = new ArrayList(expected);
		Object[] actual = list.toArray();
		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void addToEnd() {
		Object[] elements = {1,3,4};
		ListInterface list = new ArrayList(elements);
		list.add(5);
		Object expected = 5;
		Object actual = list.get(3);
		assertEquals(expected, actual);
	}

	@Test
	public void addToIndex() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		list.add(0,5);
		Object expected = 5;
		Object actual = list.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void addAllToEnd() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		Object [] toAdd = {8,9};
		list.addAll(toAdd);
		Object expected = 8;
		Object actual = list.get(3);
		assertEquals(expected, actual);
	}

	@Test
	public void addAllToIndex() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		Object [] toAdd = {8,9};
		list.addAll(1, toAdd);
		Object expected = 9;
		Object actual = list.get(2);
		assertEquals(expected, actual);
	}

	@Test
	public void set() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		list.set(2,9);
		Object expected = 9;
		Object actual = list.get(2);
		assertEquals(expected, actual);
	}

	@Test
	public void removeOneElement() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		list.remove(2);
		int expected = 2;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void removeBlock() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		list.remove(1,2);
		int expected = 1;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void clear() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList(elements);
		list.clear();
		int expected = 0;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void trimToSize() {
		Object[] elements = {1,3,5};
		ListInterface list = new ArrayList();
		list.addAll(elements);
		((ArrayList)list).trimToSize();
		int expected = 3;
		int actual = ((ArrayList) list).capacity();
		assertSame(expected, actual);
	}
}