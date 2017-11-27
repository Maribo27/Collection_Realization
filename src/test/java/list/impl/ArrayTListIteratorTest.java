package list.impl;

import list.TListIterator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTListIteratorTest {
	@Test
	public void hasNext() throws Exception {
		Object[] elems = {1,3,5};
		TArrayList list = new TArrayList(elems);
		TListIterator listIterator = list.iterator();
		int iter = 0;
		boolean expected = true;
		boolean actual = true;
		while (listIterator.hasNext()){
			Object currentActual = listIterator.next();
			Object currentExpected = elems[iter++];
			if (!currentActual.equals(currentExpected)){
				actual = false;
			}
		}
		assertTrue (expected == actual);
	}

	@Test
	public void next() throws Exception {
		Object[] elems = {1,3,5};
		TArrayList list = new TArrayList(elems);
		TListIterator listIterator = list.iterator();
		int iter = 0;
		boolean expected = true;
		boolean actual = true;
		if (listIterator.hasNext()){
			Object currentActual = listIterator.next();
			Object currentExpected = elems[iter];
			actual = currentActual.equals(currentExpected);
		}
		assertTrue (expected == actual);
	}

	@Test
	public void hasPrev() throws Exception {
		Object[] elems = {1,3,5};
		TArrayList list = new TArrayList(elems);
		TListIterator listIterator = list.iterator();
		int iter = 2;
		boolean expected = true;
		boolean actual = true;
		while (listIterator.hasPrev()){
			Object currentActual = listIterator.prev();
			Object currentExpected = elems[iter--];
			if (!currentActual.equals(currentExpected)){
				actual = false;
			}
		}
		assertTrue (expected == actual);
	}

	@Test
	public void prev() throws Exception {
		Object[] elems = {1,3,5};
		TArrayList list = new TArrayList(elems);
		TListIterator listIterator = list.iterator();
		int iter = 2;
		boolean expected = true;
		boolean actual = true;
		if (listIterator.hasPrev()){
			Object currentActual = listIterator.next();
			Object currentExpected = elems[iter];
			actual = currentActual.equals(currentExpected);
		}
		assertTrue (expected == actual);
	}
}