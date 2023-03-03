package com.map.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
//		Node<String, Integer> node1 = new Node<>("kazi", "kazi".hashCode(), 24, null);
//		Node<String, Integer> node2 = new Node<>("tanvir", "tanvir".hashCode(), 57, null);
//		Node<String, Integer> node3 = new Node<>("azad", "azad".hashCode(), 88, null);
//		Node<String, Integer> node4 = new Node<>("fahim", "fahim".hashCode(), 14, null);
//		node1.setNext(node2);
//		node3 = node4;
//		Node<String, Integer> newNode = node1.getNext();
//		newNode = node3;
//		Map<String, Integer> map = new HashMap<>();
		KaziHashMap<String, Integer> map = new KaziHashMap<>();
		map.put("Aa", 23);
		map.put("Aa", 44);
		map.put("BB", 89);
		map.put("Kazi", 22);
//		Iterator<String> iterator = map.keySet().iterator();
//		while (iterator.hasNext()) {
//			String key = iterator.next();
//			System.out.println(map.get(key));
//		}
//		var a = 11;
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();

//		set.add(12);
//		set.add(34);
//		set.add(12);
//		set.add(77);
//		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			String val = iterator.next();
			System.out.println(val);
		}
	}

}
