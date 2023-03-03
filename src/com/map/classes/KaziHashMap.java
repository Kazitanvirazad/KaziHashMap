package com.map.classes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KaziHashMap<K, V> {
	private Node<K, V>[] table;
	private int threshold;
	private float loadFactor;
	private int size;
	private Set<K> keySet;

	public KaziHashMap() {
		this.table = new Node[16];
		this.size = 0;
		this.loadFactor = 0.75f;
		this.keySet = new HashSet<>();
		this.threshold = (int) (this.loadFactor * getTable().length);
	}

	public Node<K, V> put(K key, V value) {
		int hash = getHashCode(key);
		int index = getHashIndex(hash);
		Node<K, V> node = createNode(key, hash, value, null);
		boolean isNodeInserted = insertNodeToTableIndex(node, index);
		if (isNodeInserted) {
			keySet.add(key);
			return node;
		} else {
			return null;
		}
	}

	private boolean insertNodeToTableIndex(Node<K, V> node, int index) {
		if (index >= 0 && index < getTable().length) {
			setNodeInLinkedList(index, node);
			increaseSize();
			return true;
		} else {
			return false;
		}
	}

	private void setNodeInLinkedList(int index, Node<K, V> entered_node) {
		Node<K, V> initialNode = this.table[index];
		if (this.table[index] == null) {
			this.table[index] = entered_node;
		} else {
			do {
				if (initialNode.getKey().equals(entered_node.getKey())) {
					break;
				}
				if (initialNode.hasNext()) {
					initialNode.assignNode(initialNode.getNext());
				}
			} while (initialNode.hasNext());

			if (initialNode.getKey().equals(entered_node.getKey())) {
				initialNode.assignNode(entered_node);
			} else {
				initialNode.setNext(entered_node);
			}
		}
	}

	private void increaseSize() {
		this.size++;
		increaseTableSize();
	}

	private void increaseTableSize() {
		if (this.size > this.threshold) {
			this.table = multiplyTableSize();
			int threshold = (int) this.loadFactor * getTable().length;
			setThreshold(threshold);
		}
	}

	public Set keySet() {
		return this.keySet;
	}

	private void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	private Node<K, V>[] getTable() {
		return this.table;
	}

	private int getSize() {
		return this.size;
	}

	private int getHashCode(K key) {
		return key.hashCode();
	}

	private int getHashIndex(int hashCode) {
		return hashCode & (getTable().length - 1);
	}

	private <K, V> Node<K, V> createNode(K key, int hash, V value, Node next) {
		return new Node<>(key, hash, value, next);
	}

	private Node<K, V>[] multiplyTableSize() {
		return Arrays.copyOf(getTable(), getTable().length * 2);
	}
}
