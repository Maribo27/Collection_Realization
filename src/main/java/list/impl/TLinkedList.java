package list.impl;

import list.ListInterface;
import list.TListIterator;

import java.io.Serializable;

import static list.ListConstants.ELEMENT_NOT_FOUND;
import static list.ListConstants.INCORRECT_INDEX;

public class TLinkedList implements ListInterface, Serializable {

	private ListElement head;
	private ListElement tail;
	private int size;

	private static class ListElement {
		private Object element;
		private ListElement next;
		private ListElement prev;

		ListElement(Object element, ListElement next, ListElement prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}

	public TLinkedList(){
		head = tail = null;
		size = 0;
	}

	public TLinkedList(Object element){
		size = 0;
		add(element);
	}

	public TLinkedList(Object[] elements){
		addAll(elements);
	}

	@Override
	public TListIterator iterator() {
		return new LinkedTListIterator(this);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void add(Object element) {
		add(size, element);
	}

	@Override
	public void add(int index, Object element) {
		boolean incorrectIndex = index > size || index < 0;
		if (incorrectIndex){
			System.out.println(INCORRECT_INDEX);
		} else if (index == 0 && size == 0){
				head = tail = new ListElement(element, null, null);
				size++;
		} else if (index == 0){
				head.prev = new ListElement(element, head, null);
				head = head.prev;
				size++;
		} else if (index == size){
			tail.next = new ListElement(element, null, tail);
			tail = tail.next;
			size++;
		} else {
			ListElement currentElement = head;
			for (int i = 0; i < index; i++) {
				currentElement = currentElement.next;
			}
			currentElement.prev.next = new ListElement(element, currentElement, currentElement.prev);
			currentElement.prev = currentElement.prev.next;
			size++;
		}
	}

	@Override
	public void addAll(int index, Object[] elements) {
		for (Object elem : elements) {
			add(index++, elem);
		}
	}

	@Override
	public void addAll(Object[] elements) {
		addAll(size, elements);
	}

	@Override
	public Object get(int index) {

		if (index >= size || index < 0){
			System.out.println(ELEMENT_NOT_FOUND);
			return null;
		}

		if (index == 0) {
			return head.element;
		} else if (index == size - 1) {
			return tail.element;
		} else {
			ListElement currentElement = head;
			for (int i = 0; i < index; i++) {
				currentElement = currentElement.next;
			}
			return currentElement.element;
		}
	}

	@Override
	public TLinkedList subList(int begin, int end) {
		if (begin < 0 || end > size || end < begin){
			System.out.println(ELEMENT_NOT_FOUND);
			return null;
		}
		if (begin == end){
			Object element = get(begin);
			return new TLinkedList(element);
		}

		TLinkedList linkedList = new TLinkedList();
		for (int index = begin; index <= end; index++){
			Object element = get(index);
			linkedList.add(element);
		}
		return linkedList;
	}

	@Override
	public void set(int index, Object element) {
		if (index >= size || index < 0){
			System.out.println(ELEMENT_NOT_FOUND);
		} else if (index == 0) {
			head.element = element;
		} else if (index == size - 1) {
			tail.element = element;
		} else {
			ListElement currentElement = head;
			for (int i = 0; i < index; i++) {
				currentElement = currentElement.next;
			}
			currentElement.element = element;
		}
	}

	@Override
	public void remove(int index) {
		if (index >= size || index < 0){
			System.out.println(ELEMENT_NOT_FOUND);
			return;
		}

		if (index == 0 && size != 1) {
			head = head.next;
			head.prev = null;
			size--;
		} else if (index == 0) {
			tail = head = null;
			size--;
		} else if (index == size - 1) {
			tail = tail.prev;
			tail.next = null;
			size--;
		} else {
			ListElement currentElement = head;
			for (int i = 0; i < index; i++) {
				currentElement = currentElement.next;
			}
			currentElement.prev.next = currentElement.next;
			currentElement.next.prev = currentElement.prev;
			size--;
		}
	}

	@Override
	public void remove(int index, int size) {
		if (size > this.size || index < 0 || size < 1){
			System.out.println(INCORRECT_INDEX);
			return;
		}

		for (int current = index + size - 1; current > index - 1; current--){
			remove(current);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		remove(0, size);
		new TLinkedList();
	}

	@Override
	public Object[] toArray(){
		Object [] array = new Object[size];
		for (int index = 0; index < size; index++){
			array[index] = get(index);
		}
		return array;
	}

	@Override
	public boolean equals(ListInterface listInterface) {
		if (this == listInterface) return true;
		if (listInterface == null || getClass() != listInterface.getClass()) return false;

		TLinkedList that = (TLinkedList) listInterface;

		if (size != that.size) return false;
		if (size == 0) return true;
		for (int index = 0; index < size; index++){
			if (that.get(index) != this.get(index)) return false;
		}
		return true;
	}

	private class LinkedTListIterator implements TListIterator {
		private int current = 0;
		private TLinkedList list;

		LinkedTListIterator(TLinkedList list) {
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