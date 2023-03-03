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

	public void setKey(K key) {
		this.key = key;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}

	public K getKey() {
		return this.key;
	}

	public int getHash() {
		return this.hash;
	}

	public V getValue() {
		return this.value;
	}

	public Node<K, V> getNext() {
		return next;
	}

}
