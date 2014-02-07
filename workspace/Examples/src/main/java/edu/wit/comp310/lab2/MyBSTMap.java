package edu.wit.comp310.lab2;

import java.util.Collection;
import java.util.HashSet;
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
		public void accept(Visitor<T> v) {
			v.visit(this);
		}
	}
	public interface Visitor<T> {
		public void visit(BinaryTreeNode<T> node);
	}
	public static void main(String[] args) {
		BinaryTreeNode<String> example = new BinaryTreeNode<String>();
		example.data = "Luke";
		example.left = new BinaryTreeNode<String>();
		example.left.data = "Jian";
		example.right = new BinaryTreeNode<String>();
		example.right.data = "Pat";
		example.left.left = new BinaryTreeNode<String>();
		example.left.left.data = "Alex";
		example.left.right = new BinaryTreeNode<String>();
		example.left.right.data = "Kyle";
		
		// example.accept(new PostfixPrinter());
		
		Counter<String> c = new Counter<String>();
		example.accept(c);
		// System.out.println(c.count);
		
		Searcher searcher = new Searcher("Luke");
		example.accept(searcher);
		System.out.println(searcher.found); // print true, please!
	}
	public static class Searcher implements Visitor<String> {
		String needle;
		boolean found = false;
		public Searcher(String needle) {
			this.needle = needle;
		}
		@Override
		public void visit(BinaryTreeNode<String> node) {
			int result = node.data.compareTo(needle);
			if (result < 0) { // data < needle
				// Visit the right side
				if (node.right != null) {
					node.right.accept(this);
				}
			} else if (result == 0) { // data == needle
				found = true;
			} else { // data > needle
				// Visit the left side
				if (node.left != null) {
					node.left.accept(this);
				}
			}
		}
	}
	public static class Counter<T> implements Visitor<T> {
		int count = 0;
		@Override
		public void visit(BinaryTreeNode<T> node) {
			count++;
			// Visit the left side
			if (node.left != null) {
				node.left.accept(this);
			}
			// Visit the right side
			if (node.right != null) {
				node.right.accept(this);
			}
		}
	}
	public static class PrefixPrinter implements Visitor<String> {
		@Override
		public void visit(BinaryTreeNode<String> node) {
			// Process the node
			System.out.println(node.data);
			// Visit the left side
			if (node.left != null) {
				node.left.accept(this);
			}
			// Visit the right side
			if (node.right != null) {
				node.right.accept(this);
			}
		}
	}
	public static class InfixPrinter implements Visitor<String> {
		@Override
		public void visit(BinaryTreeNode<String> node) {
			// Visit the left side
			if (node.left != null) {
				node.left.accept(this);
			}
			// Process the node
			System.out.println(node.data);
			// Visit the right side
			if (node.right != null) {
				node.right.accept(this);
			}
		}
	}
	public static class PostfixPrinter implements Visitor<String> {
		@Override
		public void visit(BinaryTreeNode<String> node) {
			// Visit the left side
			if (node.left != null) {
				node.left.accept(this);
			}
			// Visit the right side
			if (node.right != null) {
				node.right.accept(this);
			}
			// Process the node
			System.out.println(node.data);
		}
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
		Set<java.util.Map.Entry<Key, Value>> result = new HashSet<java.util.Map.Entry<Key, Value>>();
		// populate the set with everything in the the tree.
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
		Set<Key> set = new HashSet<Key>();
		// populate the set with every key in the the tree.
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
