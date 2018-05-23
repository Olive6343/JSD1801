package com.ldq.collection;

import java.util.TreeMap;

public class TreeMapTest {
	
	public static void main(String[] args) {
		int[] arr = {5,6,8,3,5,1,8,4,5};
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		for(int i=0;i<arr.length;i++){
			tm.put(i+1, arr[i]);
		}
		System.out.println(tm.values());
		
		TreeMap<String, String> tm2 = new TreeMap<>();
		
		
	}
	
}
