package com.map.classes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KaziHashMap<K, V> {
	private Node<K, V>[] table;
	private int threshold;
	private final float loadFactor;
	private int size;
	private Set<K> keySet;

	public KaziHashMap() {
		this.table = new Node[16];
		this.size = 0;
		this.loadFactor = 0.75f;
		this.keySet = new HashSet<>();
		this.threshold = (int) (this.loadFactor * getTable().length);
	}

	public KaziHashMap(int initialCapacity, float loadFactor) {
		this.table = new Node[initialCapacity];
		this.size = 0;
		this.loadFactor = loadFactor;
		this.keySet = new HashSet<>();
		this.threshold = (int) (this.loadFactor * getTable().length);
	}

	public KaziHashMap(int initialCapacity) {
		this.table = new Node[initialCapacity];
		this.size = 0;
		this.loadFactor = 0.75f;
		this.keySet = new HashSet<>();
		this.threshold = (int) (this.loadFactor * getTable().length);
	}

	public KaziHashMap(float loadFactor) {
		this.table = new Node[16];
		this.size = 0;
		this.loadFactor = loadFactor;
		this.keySet = new HashSet<>();
		this.threshold = (int) (this.loadFactor * getTable().length);
	}

	public V get(K key) {
		V value = null;
		int hash = getHashCode(key);
		int index = getHashIndex(hash);
		Node<K, V> initialNode = this.table[index];
		if (this.table[index] != null) {
			value = getValueFromKey(initialNode, key);
		}

		return value;
	}

	public Node<K, V> put(K key, V value) {
		int hash = getHashCode(key);
		int index = getHashIndex(hash);
		Node<K, V> node = createNode(key, hash, value, null);
		boolean isNodeInserted = insertNodeToTableIndex(node, index);
		if (isNodeInserted) {
			return node;
		} else {
			return null;
		}
	}

	private V getValueFromKey(Node<K, V> initialNode, K key) {
		V value = null;
		do {
			if (initialNode.getKey().equals(key)) {
				break;
			}
			if (initialNode.hasNext()) {
				initialNode = initialNode.getNext();
			}
		} while (initialNode.hasNext());
		if (initialNode.getKey().equals(key)) {
			value = initialNode.getValue();
		}
		return value;
	}

	private boolean insertNodeToTableIndex(Node<K, V> node, int index) {
		if (index >= 0 && index < getTable().length) {
			setNodeInLinkedList(index, node);
			return true;
		} else {
			return false;
		}
	}

	private void setNodeInLinkedList(int index, Node<K, V> entered_node) {
		Node<K, V> initialNode = this.table[index];
		if (this.table[index] == null) {
			this.table[index] = entered_node;
			this.keySet.add(entered_node.getKey());
			increaseSize();
		} else {
			do {
				if (initialNode.getKey().equals(entered_node.getKey())) {
					break;
				}
				if (initialNode.hasNext()) {
					initialNode = initialNode.getNext();
				}
			} while (initialNode.hasNext());

			if (initialNode.getKey().equals(entered_node.getKey())) {
				entered_node.setNext(initialNode.getNext());
				initialNode.assignNode(entered_node);
			} else {
				initialNode.setNext(entered_node);
				this.keySet.add(entered_node.getKey());
				increaseSize();
			}
		}
	}

	private void increaseSize() {
		this.size++;
		increaseTableSize();
	}

	private void increaseTableSize() {
		if (this.size > this.threshold) {
			this.table = getCopiedElementsWithReHashedMultipliedTableSize();
			int threshold = (int) (this.loadFactor * getTable().length);
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

	public int size() {
		return this.size;
	}

	private int getHashCode(K key) {
		return key.hashCode();
	}

	private int getHashIndex(int hashCode) {
		return hashCode & (getTable().length - 1);
	}

	private int getHashIndex(int hashCode, int tableLength) {
		return hashCode & (tableLength - 1);
	}

	private <K, V> Node<K, V> createNode(K key, int hash, V value, Node next) {
		return new Node<>(key, hash, value, next);
	}

	private Node<K, V>[] getCopiedElementsWithReHashedMultipliedTableSize() {
		Node<K, V>[] newTable = new Node[getTable().length * 2];
		int newTableLength = newTable.length;
		Iterator<String> iterator = this.keySet().iterator();
		while (iterator.hasNext()) {
			K key = (K) iterator.next();
			V value = get(key);
			int hash = getHashCode(key);
			int index = getHashIndex(hash, newTableLength);
			Node<K, V> new_node = createNode(key, hash, value, null);

			Node<K, V> initialNode = newTable[index];

			if (newTable[index] == null) {
				newTable[index] = new_node;
			} else {
				do {
					if (initialNode.getKey().equals(new_node.getKey())) {
						break;
					}
					if (initialNode.hasNext()) {
						initialNode = initialNode.getNext();
					}
				} while (initialNode.hasNext());

				if (initialNode.getKey().equals(new_node.getKey())) {
					new_node.setNext(initialNode.getNext());
					initialNode.assignNode(new_node);
				} else {
					initialNode.setNext(new_node);
				}
			}
		}
		return newTable;
	}
}
