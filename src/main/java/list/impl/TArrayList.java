package list.impl;

import list.ListInterface;
import list.TListIterator;

import java.io.Serializable;
import java.util.Arrays;

import static list.ListConstants.*;

public class TArrayList implements ListInterface, Serializable{
	private Object[] array;
	private int position = 0;
	private int size = 0;
	private int capacity = 16;
	private int CAPACITY = 16;

	public TArrayList(int capacity){
		array = new Object[capacity];
		this.capacity = capacity;
	}

	public TArrayList(Object[] array){
		this.array = array;
		capacity = size = position = array.length;
	}

	public TArrayList(){
		array = new Object[CAPACITY];
	}

	@Override
	public TListIterator iterator() {
		return new ArrayTListIterator(this);
	}

	@Override
	public boolean isEmpty(){
		return size == 0;
	}

	@Override
	public void add(Object element) {
		add(position, element);
	}

	@Override
	public void add(int index, Object element) {
		if (index > size || index < 0){
			System.out.println(INCORRECT_INDEX);
			return;
		}
		int prevSize = size++;
		if (position == capacity) {
			ensureCapacity();
		}
		System.arraycopy(array, index, array, index + 1, prevSize - index);
		array[index] = element;
		position++;
	}

	@Override
	public void addAll(Object[] elements) {
		addAll(position,elements);
	}

	@Override
	public void addAll(int index, Object[] elements) {
		if (index > size || index < 0 || (size == 0 && index != 0)){
			System.out.println(INCORRECT_INDEX);
			return;
		}

		if (size - position <= elements.length) {
			int delta = size - position + elements.length;
			ensureCapacity(size + delta);
		}

		for (int iterator = size - 1; iterator > elements.length; iterator--){
			array[iterator] = array[iterator - elements.length];
		}

		System.arraycopy(elements, 0, array, index, elements.length);
		position += elements.length;
	}

	@Override
	public Object get(int index) {
		if (index > size || index < 0){
			System.out.println(ELEMENT_NOT_FOUND);
			return null;
		}
		return array[index];
	}

	@Override
	public TArrayList subList(int begin, int end){
		if (begin < 0 || end > size || end < begin){
			System.out.println(ELEMENT_NOT_FOUND);
			return null;
		}
		Object[] newArray = new Object[end - begin + 1];
		System.arraycopy(array,begin,newArray,0,end - begin + 1);
		return new TArrayList(newArray);
	}

	@Override
	public void set(int index, Object element){
		if (index > size || index < 0){
			System.out.println(BIG_INDEX);
			return;
		}
		array[index] = element;
	}

	@Override
	public void remove(int index) {
		remove(index,1);
	}

	@Override
	public void remove(int index, int size) {
		if (size > this.size || index < 0 || size < 1){
			System.out.println(TOO_MUCH_TO_DELETE);
			return;
		}
		System.arraycopy(array, index + size, array, index, array.length - index - size);
		while (position > position - size){
			array[--position] = null;
			size--;
			this.size--;
		}
	}

	@Override
	public int size() {
		return size;
	}

	public int capacity() {
		return capacity;
	}

	@Override
	public void clear() {
		for (int index = 0; index < size; index++){
			remove(index);
		}
		size = 0;
		position = 0;
	}

	@Override
	public boolean equals(ListInterface listInterface){
		if (this == listInterface) return true;
		if (listInterface == null || getClass() != listInterface.getClass()) return false;

		TArrayList list = (TArrayList) listInterface;

		if (position != list.position) return false;
		if (size != list.size) return false;
		return Arrays.equals(array, list.array);
	}

	@Override
	public Object[] toArray(){
		Object [] array = new Object[size];
		for (int index = 0; index < size; index++){
			array[index] = get(index);
		}
		return array;
	}

	public void trimToSize(){
		if (size == 0){
			capacity = CAPACITY;
		} else {
			capacity = size;
		}
	}

	private void ensureCapacity(){
		capacity = (capacity * 3) / 2 + 1;
		Object[] tempArray = new Object[capacity];
		System.arraycopy(array, 0, tempArray, 0, position);
		array = tempArray;
		size = array.length;
	}

	private void ensureCapacity(int newLength) {
		Object[] tempArray = new Object[newLength];
		System.arraycopy(array, 0, tempArray, 0, position);
		array = tempArray;
		size = array.length;
	}

	private class ArrayTListIterator implements TListIterator {
		private int current = 0;
		private TArrayList list;

		ArrayTListIterator(TArrayList list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			return list.size > current;
		}

		@Override
		public Object next() {
			if (hasNext()) {
				return list.get(current++);
			}
			return null;
		}

		@Override
		public boolean hasPrev() {
			return current > 0;
		}

		@Override
		public Object prev() {
			if (hasPrev()) {
				return list.get(current--);
			}
			return null;
		}
	}
}
