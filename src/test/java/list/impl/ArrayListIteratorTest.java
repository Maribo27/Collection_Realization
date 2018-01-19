package list.impl;

import list.ListIterator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArrayListIteratorTest {
	@Test
	public void hasNext() {
		Object[] elements = {1,3,5};
		ArrayList list = new ArrayList(elements);
		ListIterator listIterator = list.iterator();
		int iterator = 0;
		boolean expected = true;
		boolean actual = true;
		actual = isActual(elements, listIterator, iterator, actual);
		assertTrue (expected == actual);
	}

	static boolean isActual(Object[] elements, ListIterator listIterator, int iterator, boolean actual) {
		while (listIterator.hasNext()){
			Object currentActual = listIterator.next();
			Object currentExpected = elements[iterator++];
			if (!currentActual.equals(currentExpected)){
				actual = false;
			}
		}
		return actual;
	}

	@Test
	public void next() {
		Object[] elements = {1,3,5};
		ArrayList list = new ArrayList(elements);
		ListIterator listIterator = list.iterator();
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
	public void hasPrev() {
		Object[] elements = {1,3,5};
		ArrayList list = new ArrayList(elements);
		ListIterator listIterator = list.iterator();
		int iterator = 2;
		boolean expected = true;
		boolean actual = true;
		actual = findPrev(elements, listIterator, iterator, actual);
		assertTrue (expected == actual);
	}

	static boolean findPrev(Object[] elements, ListIterator listIterator, int iterator, boolean actual) {
		while (listIterator.hasPrev()){
			Object currentActual = listIterator.prev();
			Object currentExpected = elements[iterator--];
			if (!currentActual.equals(currentExpected)){
				actual = false;
			}
		}
		return actual;
	}

	@Test
	public void prev() {
		Object[] elements = {1,3,5};
		ArrayList list = new ArrayList(elements);
		ListIterator listIterator = list.iterator();
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