package com.map.classes;

import java.util.Iterator;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

		KaziHashMap<String, Integer> map = new KaziHashMap<>();
		map.put("Aa", 23);
		map.put("Aa", 44);
		map.put("BB", 89);
		map.put("Kazi", 22);
		map.put("bb", 678);
		map.put("Wr", 2323);
		map.put("Aa", 100);
		map.put("yo", 890);
		map.put("erytu", 234);
		map.put("bhj", 234633);
		map.put("qwr", 225325);
		map.put("ui", 679);
		map.put("Kazi", 12);
		map.put("azad", 432);
		map.put("tanvir", 123);
		map.put("fahim", 780);
		map.put("java", 222);

		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();

		int count = 1;
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer val = map.get(key);
			System.out.println(count + " - " + key + " <--key--value--> " + val);
			count++;
		}
		System.out.println("\nMap Size: " + map.size());
	}

}
