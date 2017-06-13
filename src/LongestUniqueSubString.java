import java.util.HashMap;
public class LongestUniqueSubString {
	// This program returns the longest unique substring in a string 

		public static void main(String[] args) {
			String str = "AABDSJKKSFB";
			int len = str.length();
			int total = 0;
			HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
			
			for(int i=0; i<len; i++) {
				System.out.print(str.charAt(i));
				int nextIndex = str.indexOf(str.charAt(i), i+1);
				if(nextIndex==-1) {
					total = len-i;
				count.put(i, total);
				}
				else {
					total = nextIndex-i;
					count.put(i, total);
				}
			}
			System.out.println();
			int max = 0;
			int index = 0;
			for(int in : count.keySet()) {
//				System.out.println(count.get(in));
				if(max>count.get(in));
				else {
				max = count.get(in);
				index = in;
				}
			}
			System.out.println("max is "+max);
			System.out.println(str.substring(index, index+max));
		}
	}

