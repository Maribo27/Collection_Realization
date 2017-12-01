package list.impl;

import list.TListIterator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArrayTListIteratorTest {
	@Test
	public void hasNext() throws Exception {
		Object[] elements = {1,3,5};
		TArrayList list = new TArrayList(elements);
		TListIterator listIterator = list.iterator();
		int iterator = 0;
		boolean expected = true;
		boolean actual = true;
		while (listIterator.hasNext()){
			Object currentActual = listIterator.next();
			Object currentExpected = elements[iterator++];
			if (!currentActual.equals(currentExpected)){
				actual = false;
			}
		}
		assertTrue (expected == actual);
	}

	@Test
	public void next() throws Exception {
		Object[] elements = {1,3,5};
		TArrayList list = new TArrayList(elements);
		TListIterator listIterator = list.iterator();
		int iterator = 0;
		boolean expected = true;
		boolean actual = true;
		if (listIterator.hasNext()){
			Object currentActual = listIterator.next();
			Object currentExpected = elements[iterator];
			actual = currentActual.equals(currentExpected);
		}
		assertTrue (expected == actual);
	}

	@Test
	public void hasPrev() throws Exception {
		Object[] elements = {1,3,5};
		TArrayList list = new TArrayList(elements);
		TListIterator listIterator = list.iterator();
		int iterator = 2;
		boolean expected = true;
		boolean actual = true;
		while (listIterator.hasPrev()){
			Object currentActual = listIterator.prev();
			Object currentExpected = elements[iterator--];
			if (!currentActual.equals(currentExpected)){
				actual = false;
			}
		}
		assertTrue (expected == actual);
	}

	@Test
	public void prev() throws Exception {
		Object[] elements = {1,3,5};
		TArrayList list = new TArrayList(elements);
		TListIterator listIterator = list.iterator();
		int iterator = 2;
		boolean expected = true;
		boolean actual = true;
		if (listIterator.hasPrev()){
			Object currentActual = listIterator.next();
			Object currentExpected = elements[iterator];
			actual = currentActual.equals(currentExpected);
		}
		assertTrue (expected == actual);
	}
}