package com.map.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
//		Map<String, Integer> map = new HashMap<>();
		KaziHashMap<String, Integer> map = new KaziHashMap<>();
		map.put("Aa", 23);
		map.put("Aa", 44);
		map.put("BB", 44);
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
