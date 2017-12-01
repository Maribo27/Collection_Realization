package list;

public interface ListInterface {

	TListIterator iterator();

	Object get(int index);

	ListInterface subList(int begin, int end);

	Object[] toArray();

	boolean isEmpty();

	boolean equals(ListInterface listInterface);

	int size();

	void add(Object element);

	void add(int index, Object element);

	void addAll(int index, Object[] elements);

	void addAll(Object[] elements);

	void set(int index, Object element);

	void remove(int index);

	void remove(int index, int size);

	void clear();
}