package jacklaiu.search.test;

import jacklaiu.search.SequentialSearchST;
import jacklaiu.utils.StdIn;
import jacklaiu.utils.StdOut;

public class FrequencyCounter {
	
	public static void main(String[] args) {
		int minlen = 10;
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		while(!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if(word.length() < minlen) continue;
			if(!st.contains(word)) st.put(word, 1);
			else                   st.put(word, st.get(word) + 1);
		}
		//找出频率最高的单词
		String max = "";
		st.put(max, 0);
		for(String word: st.keys()) {
			if(st.get(word) > st.get(max)) {
				max = word;
			}
		}
		StdOut.println(max + " " + st.get(max));
	}

}
