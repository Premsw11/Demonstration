package Basic;

public class LongestUniqueSubString {
	public static void main(String[] args) {
		String str = "AJSHDGFTAGSFDRVCGF";
		int len = str.length();
		int count = 0;
		/*for(int i=0;i<len;i++) {
			char c = str.charAt(i);
			while(str.charAt(i)!=c) {
				count++;
			}
		}*/
		
//	System.out.println("count is "+count);
		for(int i=0;i<len;i++) {
		System.out.println(str.indexOf(str.charAt(i)));
		}
		}
}
