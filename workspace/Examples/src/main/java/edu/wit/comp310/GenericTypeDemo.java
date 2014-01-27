package edu.wit.comp310;

public class GenericTypeDemo {
	public static class LousyContainer {
		Object item;
	}
	public static class NiceContainer<T> {
		T item;
	}

	public static void main(String[] args) {
		LousyContainer a = new LousyContainer();
		a.item = "Hi!";
		LousyContainer b = new LousyContainer();
		b.item = "Hi!";
		
		LousyContainer c = new LousyContainer();
		c.item = "Hello";
		// We're forced to type-cast. Barf! :-P
		String s = (String)c.item;
		
		NiceContainer<String> c2 = new NiceContainer<String>();
		c2.item = "Howdy";
		// Bam! It's type-safe! Huzzah!
		String s2 = c2.item;
	}

}
