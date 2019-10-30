package AED.Assignment6;

import java.util.HashMap;

public class Q3_anagram {
	
	public static boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> h2 = new HashMap<Character, Integer>();
		 if(s.length()!=t.length())
	            return false;
		for(int i=0;i<s.length();i++) {
			if(h1.containsKey(s.charAt(i))) {
				h1.put(s.charAt(i), h1.get(s.charAt(i))+1);
			}
			else
			h1.put(s.charAt(i), 1);
		}
		System.out.println(h1.toString());
		for(int i=0;i<t.length();i++) {
			if(h2.containsKey(t.charAt(i))) {
				h2.put(t.charAt(i), h2.get(t.charAt(i))+1);
			}
			else
			h2.put(t.charAt(i), 1);
		}
		System.out.println(h2.toString());
		if(h1.equals(h2)) {
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		String s1 = "anagram";
		String s2 = "bguuuhi";
		boolean value = isAnagram(s1,s2);
		System.out.println(value);
	}
}
