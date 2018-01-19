package tree.impl;

import list.ListInterface;
import list.impl.ArrayList;
import org.junit.Before;
import org.junit.Test;
import tree.TreeInterface;

import static org.junit.Assert.*;

public class BinaryTreeTest {

	private Comparable [] treeMass;

	@Before
	public void setUp() {
		treeMass = new Comparable[]{13,20,15,11,4,21,2,1,9,5,6,10,7};
	}

	@Test
	public void size() {
		TreeInterface tree = new BinaryTree(treeMass);
		int expected = 13;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void isNotEmpty() {
		TreeInterface tree = new BinaryTree(treeMass);
		boolean expected = false;
		boolean actual = tree.isEmpty();
		assertTrue(expected == actual);
	}

	@Test
	public void isEmpty() {
		TreeInterface tree = new BinaryTree();
		boolean expected = true;
		boolean actual = tree.isEmpty();
		assertTrue(expected == actual);
	}

	@Test
	public void add() {
		TreeInterface tree = new BinaryTree(treeMass);
		tree.add(8);
		boolean expected = true;
		boolean actual = tree.contains(8);
		assertTrue(expected == actual);
	}

	@Test
	public void addAll() {
		TreeInterface tree = new BinaryTree(8);
		Comparable[] values = new Comparable[] {1,9,25,7};
		tree.addAll(values);
		int expected = 5;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void contains() {
		TreeInterface tree = new BinaryTree(treeMass);
		boolean expected = true;
		boolean actual = tree.contains(13);
		assertTrue(expected == actual);
	}

	@Test
	public void remove() {
		TreeInterface tree = new BinaryTree(treeMass);
		tree.remove(4);
		int expected = 12;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void clear() {
		TreeInterface tree = new BinaryTree(treeMass);
		tree.clear();
		int expected = 0;
		int actual = tree.size();
		assertEquals(expected, actual);
	}

	@Test
	public void getChildTree() {
		TreeInterface tree = new BinaryTree(treeMass);
		Comparable[] values = new Comparable[] {4,2,1,9,5,10,6,7};
		TreeInterface expected = new BinaryTree(values);
		TreeInterface actual = tree.getChildTree(4);
		assertTrue(expected.equals(actual));
	}

	@Test
	public void toArrayInOrder() {
		TreeInterface tree = new BinaryTree(treeMass);
		Object[] values = new Object[] {1,2,4,5,6,7,9,10,11,13,15,20,21};
		ListInterface expected = new ArrayList(values);
		ListInterface actual = tree.toArrayInOrder();
		assertTrue(expected.equals(actual));
	}

	@Test
	public void toArrayPreOrder() {
		TreeInterface tree = new BinaryTree(treeMass);
		Object[] values = new Object[] {13,11,4,2,1,9,5,6,7,10,20,15,21};
		ListInterface expected = new ArrayList(values);
		ListInterface actual = tree.toArrayPreOrder();
		assertTrue(expected.equals(actual));
	}

	@Test
	public void toArrayPostOrder() {
		TreeInterface tree = new BinaryTree(treeMass);
		Object[] values = new Object[] {1,2,7,6,5,10,9,4,11,15,21,20,13};
		ListInterface expected = new ArrayList(values);
		ListInterface actual = tree.toArrayPostOrder();
		assertTrue(expected.equals(actual));
	}
}