package tree.impl;

import list.ListInterface;
import list.impl.ArrayList;
import tree.TreeConstants;
import tree.TreeInterface;

import java.io.Serializable;
import java.util.Objects;

public class BinaryTree implements TreeInterface, Serializable {
	private Node rootNode;
	private int size;

	private class Node {
		private Comparable value;
		private Node left;
		private Node right;

		Node(Comparable value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Node node = (Node) o;
/*
			if (value != null ? !value.equals(node.value) : node.value != null) return false;
			if (left != null ? !left.equals(node.left) : node.left != null) return false;
			return right != null ? right.equals(node.right) : node.right == null;

*/
			return Objects.equals(value, node.value) &&
					Objects.equals(left, node.left) &&
					Objects.equals(right, node.right);
		}

		@Override
		public int hashCode() {
			return Objects.hash(value, left, right);
		}


	}

	public BinaryTree() {
		rootNode = null;
	}

	public BinaryTree(Comparable<Integer> value) {
		this();
		add(value);
	}

	public BinaryTree(Comparable [] values) {
		this();
		for (Comparable value : values) {
			add(value);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty(){
		return size == 0 || rootNode == null;
	}

	@Override
	public void add(Comparable value) {
		if (value == null) {
			System.out.println(TreeConstants.INCORRECT_INPUT_DATA);
			return;
		}
		if (contains(value)) {
			System.out.println(TreeConstants.DATA_IS_EXIST);
			return;
		}
		if (isEmpty()) {
			rootNode = new Node(value);
			size++;
			return;
		}
		add(rootNode, value);
		size++;
	}

	@Override
	public void addAll(Comparable [] values) {
		for (Comparable value : values) {
			if (value == null) {
				continue;
			}
			if (isEmpty()) {
				rootNode = new Node(value);
				size++;
				return;
			}
			add(rootNode, value);
			size++;
		}
	}

	@Override
	public boolean contains(Comparable value) {
		Node node = searchChild(rootNode, value);
		return node != null;
	}

	@Override
	public void remove(Comparable value) {
		Node node = searchChild(rootNode, value);
		if (node == null) {
			System.out.println(TreeConstants.INCORRECT_INPUT_DATA);
			return;
		}

		if (node.right != null) {
			Node min = getMinimum(node.right);
			node.value = min.value;
			swapNodes(min, min.right);
		} else {
			swapNodes(node, node.left);
		}
		size--;
	}

	@Override
	public void clear() {
		rootNode = removeAll(rootNode);
		rootNode = null;
	}

	@Override
	public BinaryTree getChildTree(Comparable value) {
		Node node = searchChild(rootNode, value);

		if (node == null) {
			System.out.println(TreeConstants.INCORRECT_INPUT_DATA);
			return null;
		}

		BinaryTree childTree = new BinaryTree();
		Node rootNode = childTree.createChildTree(node);
		childTree.setRoot(rootNode);

		return childTree;
	}

	@Override
	public ListInterface toArrayInOrder() {
		ListInterface result = new ArrayList(size);
		Node current = rootNode;
		toArrayInOrder(current, result);
		return result;
	}

	@Override
	public ListInterface toArrayPreOrder() {
		ListInterface result = new ArrayList(size);
		Node current = rootNode;
		toArrayPreOrder(current, result);
		return result;
	}

	@Override
	public ListInterface toArrayPostOrder() {
		ListInterface result = new ArrayList(size);
		Node current = rootNode;
		toArrayPostOrder(current, result);
		return result;
	}

	@Override
	public boolean equals(TreeInterface tree) {
		if (this == tree) return true;
		if (tree == null || getClass() != tree.getClass()) return false;

		BinaryTree that = (BinaryTree) tree;

		return size == that.size &&
				Objects.equals(rootNode, that.rootNode);
	}

	private void add(Node node, Comparable value) {
		int compareResult = node.value.compareTo(value);
		if (compareResult > 0) {
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				add(node.left, value);
			}
		} else if (compareResult < 0) {
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				add(node.right, value);
			}
		}
	}

	private void setRoot(Node rootNode) {
		this.rootNode = rootNode;
	}

	private Node getMinimum(Node node) {
		if (node.left == null){
			return node;
		}
		Node min = node.left;
		while(min.left != null){
			min = min.left;
		}
		return min;
	}

	private void swapNodes(Node node, Node otherNode) {
		if (otherNode == null){
			changeParentNode(node, rootNode);
		} else {
			node.value = otherNode.value;
			node.left = otherNode.left;
			node.right = otherNode.right;
		}
	}

	private void changeParentNode(Node node, Node parent) {

		Comparable par = parent.value;
		Comparable child = node.value;

		if (parent.left != null && parent.left.equals(node)) {
			parent.left = null;
			return;
		}

		if (parent.right != null && parent.right.equals(node)) {
			parent.right = null;
			return;
		}

		int compareResult = par.compareTo(child);
		if (compareResult > 0) {
			changeParentNode(node, parent.left);
		} else {
			changeParentNode(node, parent.right);
		}
	}

	private Node removeAll(Node node) {
		if (node == null) {
			return null;
		}

		if (node.left != null) {
			node.left = removeAll(node.left);
		}

		if (node.right != null) {
			node.right = removeAll(node.right);
		}

		node.value = null;
		size--;
		return node;
	}

	private Node createChildTree(Node nodeToCopy) {
		if (nodeToCopy == null) {
			return null;
		}

		Node node = new Node(nodeToCopy.value);

		if (nodeToCopy.left != null) {
			node.left = createChildTree(nodeToCopy.left);
		}

		if (nodeToCopy.right != null) {
			node.right = createChildTree(nodeToCopy.right);
		}
		size++;
		return node;
	}

	private Node searchChild(Node node, Comparable value) {
		if (node == null || node.value.equals(value)) {
			return node;
		}

		int compareResult = node.value.compareTo(value);

		if (compareResult > 0) {
			return searchChild(node.left, value);
		} else {
			return searchChild(node.right, value);
		}
	}

	private void toArrayInOrder(Node node, ListInterface list) {
		if (node.left != null) {
			toArrayInOrder(node.left, list);
		}
		list.add(node.value);
		if (node.right != null) {
			toArrayInOrder(node.right, list);
		}
	}

	private void toArrayPreOrder(Node node, ListInterface list) {
		list.add(node.value);
		if (node.left != null) {
			toArrayPreOrder(node.left, list);
		}
		if (node.right != null) {
			toArrayPreOrder(node.right, list);
		}
	}

	private void toArrayPostOrder(Node node, ListInterface list) {
		if (node.left != null) {
			toArrayPostOrder(node.left, list);
		}
		if (node.right != null) {
			toArrayPostOrder(node.right, list);
		}
		list.add(node.value);
	}
}