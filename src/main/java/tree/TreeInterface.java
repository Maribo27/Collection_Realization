package tree;

import list.ListInterface;

public interface TreeInterface {

	boolean isEmpty();

	boolean contains(Comparable value);

	boolean equals(TreeInterface tree);

	void add(Comparable value);

	void addAll(Comparable [] values);

	void remove(Comparable value);

	void clear();

	int size();

	TreeInterface getChildTree(Comparable value);

	ListInterface toArrayInOrder();

	ListInterface toArrayPreOrder();

	ListInterface toArrayPostOrder();
}
