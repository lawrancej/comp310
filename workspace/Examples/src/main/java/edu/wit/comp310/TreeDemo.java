package edu.wit.comp310;

import java.util.ArrayList;
import java.util.List;

/**
 * A demo to demonstrate that trees are nothing more than nodes that consist of data and children.
 * It also demonstrates a primitive instance of the visitor design pattern.
 */
public class TreeDemo {
	/**
	 * Node with some data in it. 
	 * @param <T> The type of the data is specified here
	 */
	public static class Node<T> {
		private T data;
		private List<Node<T>> children = new ArrayList<Node<T>>();
		public Node(T data) {
			this.data = data;
		}
		public T getData() {
			return data;
		}
		public void addChild(Node<T> kid) {
			children.add(kid);
		}
		public List<Node<T>> getChildren() {
			return children;
		}
		public void accept(Visitor<T> visitor) {
			visitor.visit(this);
		}
	}
	/**
	 * A visitor for the Node type defined above.
	 *
	 * @param <T> The type of data in the node
	 */
	public static interface Visitor<T> {
		public void visit(Node<T> node);
	}
	/**
	 * A visitor to print out all elements in the tree.
	 * It uses indentation to show the tree hierarchy.
	 */
	public static class PrintVisitor implements Visitor<String> {
		int indent = 0;
		@Override
		public void visit(Node<String> node) {
			for (int i = 0; i < indent; i++)
				System.out.print(" ");
			System.out.println(node.getData());
			indent ++;
			for (Node<String> kid : node.getChildren()) {
				// Accept will call visit in turn.
				// Mutual recursion, FTW.
				kid.accept(this);
			}
			indent --;
		}
	}
	public static void main(String[] arg) {
		// Add in ancestry relationships
		// addChild is adding in parents. Confusing, I know...
		Node<String> me = new Node<String>("Joey");
		Node<String> mom = new Node<String>("Renee");
		Node<String> dad = new Node<String>("Ken");
		me.addChild(mom);
		me.addChild(dad);
		// My maternal grandparents.
		mom.addChild(new Node<String>("Cleo"));
		mom.addChild(new Node<String>("Carol"));
		// My paternal grandparents.
		dad.addChild(new Node<String>("Charles"));
		dad.addChild(new Node<String>("Mary Jane"));
		// Now, let's print it out.
		me.accept(new PrintVisitor());
	}
}
