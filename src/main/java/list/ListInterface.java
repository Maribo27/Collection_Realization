package list;

public interface ListInterface {

	boolean isEmpty();

	void add(Object element);

	void add(int index, Object element);

	void addAll(int index, Object[] elements);

	void addAll(Object[] elements);

	Object get(int index);

	void set(int index, Object element);

	void remove(int index);

	void remove(int index, int size);

	int size();

	void clear();
}