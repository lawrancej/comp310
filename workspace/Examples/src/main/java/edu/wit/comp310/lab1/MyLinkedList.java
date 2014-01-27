package edu.wit.comp310.lab1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Roll your own Singly-linked list.
 * 
 * This means that we implement ourselves.
 * 
 * The List interface is described here:
 * 
 * @see http://docs.oracle.com/javase/7/docs/api/java/util/List.html
 *
 */
public class MyLinkedList<ValueType> implements List<ValueType> {
	Node<ValueType> first;
	Node<ValueType> last;
	int size = 0;
	public static class Node<T> {
		T data;
		Node<T> next;
	}
	private void loopingExample() {
		// for (initialization; continueCondition; updateRule)
		// for (int i = 0; i < size(); i++)
		int index = 5;
		int i = 0;
		Node<ValueType> current;
		for (current = first;
				current != null && i < index - 1;
				current = current.next, i++);
		
	}
	
	@Override
	public boolean add(ValueType arg0) {
		if (this.isEmpty()) {
			Node<ValueType> newNode = new Node<ValueType>();
			newNode.data = arg0;
			first = newNode;
			last = newNode;
		}
		return false;
	}

	@Override
	public void add(int index, ValueType arg1) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("WTF?!?");
		}
		// TODO Auto-generated method stub
//		Node<T> newNode = new Node("hello", first);
//		first = newNode;
	}

	@Override
	public boolean addAll(Collection<? extends ValueType> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends ValueType> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueType get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Iterator<ValueType> iterator() {
		return new Iterator<ValueType>() {
			Node<ValueType> current = first;
			@Override
			public boolean hasNext() {
				// is there an element after current?
				return false;
			}
			@Override
			public ValueType next() {
				// Advance current to next
				// return current's data
				return null;
			}
			@Override
			public void remove() {
				// Don't bother, please
			}
		};
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<ValueType> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<ValueType> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueType remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueType set(int arg0, ValueType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<ValueType> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
