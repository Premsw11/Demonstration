package Basic;
//   To verify a word is a palindrome or not
public class Palindrome {
	public static void main(String[] args) {
		System.out.println("Please enter the word of palindrome");
		String p = "MAAM";
		System.out.println("The word is "+p);
		System.out.println("length of p is :"+p.length());
		System.out.println("verifying p is palindrome or not");
		for(int i=0;i<p.length()/2;i++) {
			if(p.charAt(i) == p.charAt(p.length()-1-i))
			System.out.println("char at "+i+ " is matching with char at "+(p.length()-1-i));
			else{
				System.out.println("not a palindrome");
				break;
			}
			if(i==(p.length()/2 -1))
				System.out.println("yes it is a palindrome");
		}
		
	}
}
