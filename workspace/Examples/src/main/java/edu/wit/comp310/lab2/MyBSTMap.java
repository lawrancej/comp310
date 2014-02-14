package edu.wit.comp310.lab2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a dictionary using AVL trees.
 *
 * @see http://en.wikipedia.org/wiki/AVL_tree
 * @param <Key>
 * @param <Value>
 */
public class MyBSTMap<Key extends Comparable<Key>,Value> implements Map<Key, Value> {
	private BinaryTreeNode<Pair<Key,Value>> root;
	// There we go... Let's keep track of size like we did in linked list
	int size = 0;
	private static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> parent;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		// This is the height of the tree rooted at this node,
		// Not the size of the tree
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
	public static class Debugger<T extends Comparable<T>> implements Visitor<T> {	
		int indent = 0;
		@Override
		public void visit(BinaryTreeNode<T> node) {
			for (int i = 0; i < indent; i++)
				System.out.print(" ");
			System.out.println(node.data);
			if (node.left != null) {
				indent++;
				node.left.accept(this);
				indent--;
			}
			if (node.right != null) {
				indent++;
				node.right.accept(this);
				indent--;
			}
			
		}
	}
	// Tweaked searcher to work on comparable things
	public static class Searcher<T extends Comparable<T>> implements Visitor<T> {
		// I just changed this from a String to a Pair
		T needle;
		
		// Track the parent of the node to insert at
		BinaryTreeNode<T> parent;
		// The original version just had a flag for found
		boolean found = false;
		public Searcher(T needle) {
			this.needle = needle;
		}
		@Override
		public void visit(BinaryTreeNode<T> node) {
			// So, every time we visit, we should set the parent
			// (the node where we want to do the insertion)
			// to be the current node.
			parent = node;
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

	// So, This is the clear method
	@Override
	public void clear() {
		// Garbage collection, FTW.
		root = null;
		// A little bookkeeping
		size = 0;
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
	public Value get(Object key) {
		// The object is a key, not an entry
		Pair<Key, Value> entry = new Pair<Key,Value>((Key)key, null);
		Searcher<Pair<Key,Value>> searcher = new Searcher<Pair<Key,Value>>(entry);
		root.accept(searcher);
		if (searcher.found) return searcher.parent.data.value;
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
	// At this point, the rebalancing is left to do
	// Also, I wouldn't be surprised if there were bugs in here
	@Override
	public Value put(Key key, Value value) {
		// Let's think about what we do in put.
		
		// Box up the key/value pair into a Pair object
		Pair<Key,Value> entry = new Pair<Key,Value>(key, value);
		// Make a new node
		// Usually that's what we want to do
		BinaryTreeNode<Pair<Key,Value>> newNode = new BinaryTreeNode<Pair<Key,Value>>();
		// Set the data to the entry (pair)
		newNode.data = entry;
		
		// We've got two cases
		if (root == null) {
			// if we have an empty tree, it's easy
			root = newNode;
			// Some bookkeeping
			size++;
		} else {
			// Otherwise, we've got a nonempty tree
			// So, find the place to make the insertion
			Searcher<Pair<Key,Value>> searcher = new Searcher<Pair<Key,Value>>(entry);
			// Find the parent node relevant to our interests
			root.accept(searcher);
			
//			System.out.println("Before");

//			root.accept(new Debugger<Key, Value>());
			// By this point, searcher ought to set the parent node
			// Insert node into tree
			if (searcher.parent.data.compareTo(entry) < 0) {
				searcher.parent.right = newNode;
				newNode.parent = searcher.parent;
				size++;
			} else if (searcher.parent.data.compareTo(entry) > 0) {
				searcher.parent.left = newNode;
				newNode.parent = searcher.parent;
				size++;
			} else {
				// If we're here the node data is equal to the entry's key
				// Here, we don't want to create a new node, but we've got one anyway
				// So, let's just update the value
				Value temp = searcher.parent.data.value;
				searcher.parent.data.value = value;
				// we got return the previous value
				// and we won't need to rebalance here
				// since the tree shape hasn't changed.
				return temp;
			}
			// We still need to REBALANCE if we got here :-)
			// Rebalance here (exercise for reader) ;-)
		}
		
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

	// This is a decent size method
	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
