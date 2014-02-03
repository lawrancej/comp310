package edu.wit.comp310.lab2;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.wit.comp310.lab1.MyLinkedList;

public class MyLinkedListMap<Key extends Comparable<Key>,Value> implements Map<Key,Value>{
	List<Pair<Key, Value>> list = new MyLinkedList<Pair<Key, Value>>();

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		for (Pair<Key,Value> item : list) {
			if (item.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<Key, Value>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Key> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value put(Key arg0, Value arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Value remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
