package Basic;

public class CharCount {
	public static void main(String[] args) {
		String word = "Prakash";
		System.out.println("counting letter 'a' in word : "+word);
		int count = 0;
		for(int i=0;i<word.length();i++) {
			//System.out.println(word.charAt(i));
			if(word.charAt(i)=='a' || word.charAt(i)=='A' )
			count++;
		}
		System.out.println("count is "+count);
	}
}
