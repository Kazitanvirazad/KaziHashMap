package com.map.classes;

public class Node<K, V> {
	private K key;
	private int hash;
	private V value;
	private Node<K, V> next;

	public Node(K key, int hash, V value, Node<K, V> next) {
		setKey(key);
		setHash(hash);
		setValue(value);
		setNext(next);
	}

	void assignNode(Node<K, V> node) {
		setKey(node.getKey());
		setHash(node.getHash());
		setValue(node.getValue());
		setNext(node.getNext());
	}

	boolean hasNext() {
		if (this.next == null) {
			return false;
		} else {
			return true;
		}
	}

	void setKey(K key) {
		this.key = key;
	}

	void setHash(int hash) {
		this.hash = hash;
	}

	void setValue(V value) {
		this.value = value;
	}

	void setNext(Node<K, V> next) {
		this.next = next;
	}

	K getKey() {
		return this.key;
	}

	int getHash() {
		return this.hash;
	}

	V getValue() {
		return this.value;
	}

	Node<K, V> getNext() {
		return next;
	}

}
