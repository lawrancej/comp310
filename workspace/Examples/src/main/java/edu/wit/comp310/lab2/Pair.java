package edu.wit.comp310.lab2;

import java.util.Map.Entry;

public class Pair<Key extends Comparable<Key>,Value> implements Comparable<Pair<Key,Value>>, Entry<Key, Value> {
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
	@Override
	public Key getKey() {
		return key;
	}
	@Override
	public Value getValue() {
		return value;
	}
	@Override
	public Value setValue(Value value) {
		return this.value = value;
	}
}
