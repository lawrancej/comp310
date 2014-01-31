package edu.wit.comp310.lab2;

public class Pair<Key extends Comparable<Key>,Value> implements Comparable<Pair<Key,Value>> {
	Key key;
	Value value;
	public Pair(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public int compareTo(Pair<Key, Value> arg0) {
		return key.compareTo(arg0.key);
	}
}
