package tree.impl;

import list.ListInterface;
import list.impl.TArrayList;
import org.junit.Before;
import org.junit.Test;
import tree.TreeInterface;

import static org.junit.Assert.*;

public class TBinaryTreeTest {

	private Comparable [] treeMass;

	@Before
	public void setUp() throws Exception {
		treeMass = new Comparable[]{13,20,15,11,4,21,2,1,9,5,6,10,7};
	}

	@Test
	public void size() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		int expected = 13;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void isNotEmpty() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		boolean expected = false;
		boolean actual = tree.isEmpty();
		assertTrue(expected == actual);
	}

	@Test
	public void isEmpty() throws Exception {
		TreeInterface tree = new TBinaryTree();
		boolean expected = true;
		boolean actual = tree.isEmpty();
		assertTrue(expected == actual);
	}

	@Test
	public void add() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		tree.add(8);
		boolean expected = true;
		boolean actual = tree.contains(8);
		assertTrue(expected == actual);
	}

	@Test
	public void addAll() throws Exception {
		TreeInterface tree = new TBinaryTree(8);
		Comparable[] values = new Comparable[] {1,9,25,7};
		tree.addAll(values);
		int expected = 5;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void contains() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		boolean expected = true;
		boolean actual = tree.contains(13);
		assertTrue(expected == actual);
	}

	@Test
	public void remove() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		tree.remove(4);
		int expected = 12;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void clear() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		tree.clear();
		int expected = 0;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void getChildTree() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		Comparable[] values = new Comparable[] {4,2,1,9,5,10,6,7};
		TreeInterface expected = new TBinaryTree(values);
		TreeInterface actual = tree.getChildTree(4);
		assertTrue(expected.equals(actual));
	}

	@Test
	public void toArrayInOrder() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		Object[] values = new Object[] {1,2,4,5,6,7,9,10,11,13,15,20,21};
		ListInterface expected = new TArrayList(values);
		ListInterface actual = tree.toArrayInOrder();
		assertTrue(expected.equals(actual));
	}

	@Test
	public void toArrayPreOrder() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		Object[] values = new Object[] {13,11,4,2,1,9,5,6,7,10,20,15,21};
		ListInterface expected = new TArrayList(values);
		ListInterface actual = tree.toArrayPreOrder();
		assertTrue(expected.equals(actual));
	}

	@Test
	public void toArrayPostOrder() throws Exception {
		TreeInterface tree = new TBinaryTree(treeMass);
		Object[] values = new Object[] {1,2,7,6,5,10,9,4,11,15,21,20,13};
		ListInterface expected = new TArrayList(values);
		ListInterface actual = tree.toArrayPostOrder();
		assertTrue(expected.equals(actual));
	}
}