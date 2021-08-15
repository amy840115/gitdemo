// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// 用到相同字母的放在一個list裡
package practice;

import java.util.ArrayList;
import java.util.List;

public class Practice_0813 {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("eat");
		strs.add("tea");
		strs.add("tan");
		strs.add("ate");
		strs.add("nat");
		strs.add("bat");

		// 篩選出現過的字母
		List<String> once = showOnce(strs);
//		System.out.println("有出現的字母: " + once);

		List<List<String>> box1 = new ArrayList<List<String>>();
		List<String> s = new ArrayList<String>();
		
		// 過濾重複
		for (int i = 0; i < once.size(); i++) {
			List<String> li = (pick(strs, once.get(i)));
			String s1 = li.get(0);
			if(! s.contains(s1)) {
				s.add(s1);
				box1.add(pick(strs, once.get(i)));
			}
		}
		List<List<String>> box2 = new ArrayList<List<String>>();		
		// 
		for (int i = 0; i < s.size(); i++) {
			box2.add(exportAnswer(box1.get(i), String.valueOf(s.get(i).charAt(0))));
		}
		System.out.println("final answer:" + box2);

	} // main方法結束

	//將所有單字放在一起，再篩選出只有出現一次的字母
	public static List<String> showOnce(List<String> strs) {

		String s = "";
		for (String i : strs) {
			s += i;
		}

		List<String> once = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (once.contains(String.valueOf(c))) {
				continue;
			} else {
				once.add(String.valueOf(c));
			}
		}
		return once;
	}
	
	// 第一次篩選: 依據只有出現一次的字母，將單字放入list裡面 
	// (ex. a字母的list單字都有a, b字母的list單字都有b,...字母可能重複出現在不同list)
	public static List<String> pick(List<String> strs, String s) {

		List<String> li = new ArrayList<String>();

		for (int i = 0; i < strs.size(); i++) {
			if (strs.get(i).contains(s)) {
				li.add(strs.get(i));
			}
		}
//		System.out.println(li);
	
		return li;
	}
	// 第二次篩選: 只留下有使用相同字母/字數的單字於list中
	public static List<String> exportAnswer(List<String> li, String s1){
		
		List<String> slist = new ArrayList<String>();
		for (int i = 0; i < li.size(); i++) {
			int count = 0;
			for (int j = 0; j < s1.length(); j++) {
				if(li.get(i).contains(String.valueOf(s1.charAt(j)))) {
					count++;
				}
				if(count == s1.length()) {
					slist.add(li.get(i));
				}
			}
		}
		return slist;
	}
} // 最外層
