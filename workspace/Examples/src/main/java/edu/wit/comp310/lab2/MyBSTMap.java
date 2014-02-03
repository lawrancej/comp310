package edu.wit.comp310.lab2;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Implement a dictionary using AVL trees.
 *
 * @param <Key>
 * @param <Value>
 */
public class MyBSTMap<Key extends Comparable<Key>,Value> implements Map<Key, Value> {
	private BinaryTreeNode<Pair<Key,Value>> root;
	private static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> parent;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		int subtreeHeight = 1;
		public void accept(Visitor v) {
			v.visit(this);
		}
	}
	public interface Visitor<T> {
		public void visit(BinaryTreeNode<T> node);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
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
		return 0;
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
