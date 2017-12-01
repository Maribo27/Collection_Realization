package list.impl;

import list.ListInterface;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TArrayListTest {

	@Test
	public void isEmpty() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		boolean expected = false;
		boolean actual = list.isEmpty();
		assertTrue (expected == actual);
	}

	@Test
	public void isNotEmpty() throws Exception {
		ListInterface list = new TArrayList();
		boolean expected = true;
		boolean actual = list.isEmpty();
		assertTrue (expected == actual);
	}

	@Test
	public void subList() throws Exception {
		Object[] elements = {1,3,5,7,8};
		Object[] subs = {3,5,7};
		ListInterface list = new TArrayList(elements);
		ListInterface expected = new TArrayList(subs);
		ListInterface actual = list.subList(1,3);
		assertTrue (expected.equals(actual));
	}

	@Test
	public void get() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		Object expected = 1;
		Object actual = list.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void size() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		int expected = 3;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void notEquals() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		Object[] another = {1,2};
		ListInterface newList = new TArrayList(another);
		boolean expected = false;
		boolean actual = list.equals(newList);
		assertTrue(expected == actual);
	}

	@Test
	public void equals() throws Exception {
		Object[] elements = {1,2};
		ListInterface list = new TArrayList(elements);
		Object[] another = {1,2};
		ListInterface newList = new TArrayList(another);
		boolean expected = true;
		boolean actual = list.equals(newList);
		assertTrue(expected == actual);
	}

	@Test
	public void toArray() throws Exception {
		Object[] expected = {1,3,4};
		ListInterface list = new TArrayList(expected);
		Object[] actual = list.toArray();
		assertTrue(Arrays.equals(expected, actual));
	}

	@Test
	public void addToEnd() throws Exception {
		Object[] elements = {1,3,4};
		ListInterface list = new TArrayList(elements);
		list.add(5);
		Object expected = 5;
		Object actual = list.get(3);
		assertEquals(expected, actual);
	}

	@Test
	public void addToIndex() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		list.add(0,5);
		Object expected = 5;
		Object actual = list.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void addAllToEnd() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		Object [] toAdd = {8,9};
		list.addAll(toAdd);
		Object expected = 8;
		Object actual = list.get(3);
		assertEquals(expected, actual);
	}

	@Test
	public void addAllToIndex() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		Object [] toAdd = {8,9};
		list.addAll(1, toAdd);
		Object expected = 9;
		Object actual = list.get(2);
		assertEquals(expected, actual);
	}

	@Test
	public void set() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		list.set(2,9);
		Object expected = 9;
		Object actual = list.get(2);
		assertEquals(expected, actual);
	}

	@Test
	public void removeOneElement() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		list.remove(2);
		int expected = 2;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void removeBlock() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		list.remove(1,2);
		int expected = 1;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void clear() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList(elements);
		list.clear();
		int expected = 0;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void trimToSize() throws Exception {
		Object[] elements = {1,3,5};
		ListInterface list = new TArrayList();
		list.addAll(elements);
		((TArrayList)list).trimToSize();
		int expected = 3;
		int actual = ((TArrayList) list).capacity();
		assertSame(expected, actual);
	}
}