package list.impl;

import list.ListInterface;
import org.junit.Test;

import static org.junit.Assert.*;

public class TLinkedListTest {

	@Test
	public void isEmpty() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		boolean expected = false;
		boolean actual = list.isEmpty();
		assertTrue (expected == actual);
	}

	@Test
	public void get() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		Object expected = 1;
		Object actual = list.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void size() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		int expected = 3;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void equals() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		Object[] another = {1,2};
		TLinkedList newList = new TLinkedList(another);
		boolean expected = false;
		boolean actual = list.equals(newList);
		assertTrue(expected == actual);
	}

	@Test
	public void addToEnd() throws Exception {
		Object[] elems = {1,3,4};
		ListInterface list = new TLinkedList(elems);
		list.add(5);
		Object expected = 5;
		Object actual = list.get(3);
		assertEquals(expected, actual);
	}

	@Test
	public void addToIndex() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		list.add(0,5);
		Object expected = 5;
		Object actual = list.get(0);
		assertEquals(expected, actual);
	}

	@Test
	public void addAllToEnd() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		Object [] toAdd = {8,9};
		list.addAll(toAdd);
		Object expected = 8;
		Object actual = list.get(3);
		assertEquals(expected, actual);
	}

	@Test
	public void addAllToIndex() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		Object [] toAdd = {8,9};
		list.addAll(1, toAdd);
		Object expected = 9;
		Object actual = list.get(2);
		assertEquals(expected, actual);
	}

	@Test
	public void set() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		list.set(2,9);
		Object expected = 9;
		Object actual = list.get(2);
		assertEquals(expected, actual);
	}

	@Test
	public void removeOneElement() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		list.remove(2);
		int expected = 2;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void removeBlock() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		list.remove(1,2);
		int expected = 1;
		int actual = list.size();
		assertSame(expected, actual);
	}

	@Test
	public void clear() throws Exception {
		Object[] elems = {1,3,5};
		ListInterface list = new TLinkedList(elems);
		list.clear();
		int expected = 0;
		int actual = list.size();
		assertSame(expected, actual);
	}
}