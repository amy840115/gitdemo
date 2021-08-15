package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {
	
	private Stringp[] strs;
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "ant"};
		String[] strs2 = {"row", "orw"};
		Practice prt = new Practice();
		System.out.println(prt.groupAnagrams(strs));
		
	}
	
	public  List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anas = new HashMap<>();
	    for (String str : strs) {
	    	String key = sortChars(str);
	        anas.putIfAbsent(key, new ArrayList<>());
	        anas.get(key).add(str);
	        System.out.println(anas.get(key));
	        
	    }
	    return new ArrayList<>(anas.values());
	}

	private  String sortChars(String str) {
		char[] chars = str.toCharArray();
//		System.out.println(1);
//		System.out.println(chars);
		Arrays.sort(chars);
//		System.out.println(2);
//		System.out.println(chars);
		return new String(chars);
	}
}
