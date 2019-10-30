package AED.Assignment6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class Q4_UniqueOccurances {
    public static boolean uniqueOccurrences(int[] arr) {
    	HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
    	for(int i=0;i<arr.length;i++) {
				h1.put(arr[i], h1.getOrDefault(arr[i],0 )+1);
		}
        HashSet<Integer> hSet = new HashSet<Integer>(); 
		for(Entry<Integer, Integer> map:h1.entrySet()) {
			if(!hSet.add(map.getValue()))
				return false;
		}
		return true;
    	
    }
    public static void main(String[] args) {
		int [] arr = {1,2,2,1,1,3,4,4,4,4};
		boolean value =uniqueOccurrences( arr);
		System.out.println(value);
	}
}
