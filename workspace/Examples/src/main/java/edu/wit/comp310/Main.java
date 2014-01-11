package edu.wit.comp310;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

class Main {
	/**
	 * An array is a fixed-size ordered collection.
	 * Ordered does not mean sorted, it means in a sequence.
	 * Arrays map integers (indices) to arbitrary values.
	 * Arrays provide constant time O(1) random access to elements.
	 * 
	 * To declare an array, do:
	 * 
	 * ValueType[] array;
	 * 
	 * To initialize an array, do:
	 * 
	 * array = ValueType[size];
	 * 
	 * To set the value at some index, do:
	 * 
	 * array[index] = value;
	 * 
	 * To get something from an array, do:
	 * 
	 * array[index]
	 */
	public static void arrayExample() {
		// In this example, the value type is String
		String[] greetings = new String[5];
		greetings[0] = "Hello world";
		greetings[1] = "Hola mundo";
		greetings[2] = "Bonjour terre";
		greetings[3] = "Γεια σας κόσμο";
		greetings[4] = "你好世界";
		System.out.println(String.format("%s in other languages", greetings[0]));
		for (String greeting : greetings) {
			System.out.println(greeting);
		}
	}
	/**
	 * A list is an ordered collection that can grow or shrink.
	 * 
	 * To declare a list, do:
	 * 
	 * List<ValueType> list;
	 * 
	 * The way to initialize a list depends on the implementation:
	 * 
	 * list = ArrayList<ValueType>();
	 * list = LinkedList<ValueType>();
	 * 
	 * To add a value to a list, do:
	 * 
	 * list.add(value);
	 * 
	 * To get a value from a list, do:
	 * 
	 * list.get(index);
	 */
	public static void listExample() {
		// In this example, the value type is String
		List<String> greetings = new ArrayList<String>();
		greetings.add("Hello world");
		greetings.add("Hola mundo");
		greetings.add("Bonjour terre");
		greetings.add("Γεια σας κόσμο");
		greetings.add("你好世界");
		System.out.println(String.format("%s in other languages", greetings.get(0)));
		for (String greeting : greetings) {
			System.out.println(greeting);
		}
	}
	/**
	 * List is just an interface (a collection of methods without implementations)
	 * We could supply our own.
	 * This implementation does just enough to pass the type checker, and nothing more.
	 * It does not obey the behavior we'd expect of a list.
	 * 
	 * @param <T> the ValueType
	 */
	public static class MyList<T> implements List<T> {

		@Override
		public boolean add(T e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void add(int index, T element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<T> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<T> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T set(int index, T element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<T> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	/**
	 * A map (dictionary) associates arbitrary keys with values.
	 * 
	 * To declare a map, do:
	 * 
	 * Map<KeyType, ValueType> map;
	 * 
	 * The way to initialize a map depends on the implementation.
	 * 
	 * map = HashMap<KeyType, ValueType>();
	 * 
	 * To associate a key with a value, do:
	 * 
	 * map.put(key,value);
	 * 
	 * To get the value associated with a key, do:
	 * 
	 * map.get(key);
	 */
	public static void mapExample() {
		// In this example, we associating Strings to Strings
		Map<String, String> greetings = new HashMap<String, String>();
		greetings.put("English", "Hello world");
		greetings.put("Spanish", "Hola mundo");
		greetings.put("French", "Bonjour terre");
		greetings.put("Greek", "Γεια σας κόσμο");
		greetings.put("Chinese", "你好世界");
		System.out.println(String.format("%s in other languages", greetings.get("English")));
		for (String language : greetings.keySet()) {
			System.out.println(String.format("Hello world in %s is %s", language, greetings.get(language)));
		}
	}
	/**
	 * Map is just an interface (a collection of methods without implementations)
	 * We could supply our own.
	 * This implementation does just enough to pass the type checker, and nothing more.
	 * It does not obey the behavior we'd expect of a map.
	 *
	 * @param <KeyType>
	 * @param <ValueType>
	 */
	public static class MyMap<KeyType, ValueType> implements Map<KeyType, ValueType> {

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean containsKey(Object key) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsValue(Object value) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Set<java.util.Map.Entry<KeyType, ValueType>> entrySet() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ValueType get(Object key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Set<KeyType> keySet() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ValueType put(KeyType key, ValueType value) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void putAll(Map<? extends KeyType, ? extends ValueType> m) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ValueType remove(Object key) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Collection<ValueType> values() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	public static void main (String[] args) {
		arrayExample();
		listExample();
		mapExample();
	}
}
