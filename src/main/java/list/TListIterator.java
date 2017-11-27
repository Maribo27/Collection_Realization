package list;

public interface TListIterator {
	boolean hasNext();
	Object next();

	boolean hasPrev();
	Object prev();
}