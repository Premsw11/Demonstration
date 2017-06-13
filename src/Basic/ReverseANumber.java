package Basic;
// Reverse the digits of a number
public class ReverseANumber {
	public static void main(String[] args) {
		int num = 123456;
		System.out.println("number is "+num);
		ReverseANumber rn = new ReverseANumber();
		rn.useString(num);
		rn.useInt(num);
	}
	public void useString(int num) {
		System.out.println("Converted using string");
		String st = String.valueOf(num);
		StringBuilder str = new StringBuilder();
		for(int i=st.length()-1; i>=0; i--) {
			str.append(String.valueOf(st.charAt(i)));
		}
		
		String str1 = str.toString();
		int rvnum = (int) Integer.valueOf(str1);
		System.out.println("Reversed number is "+rvnum);
	}
	public void useInt(int num) {
		System.out.println("Converted using int only");
		int revnum = 0;
		while(num!=0) {
			revnum = revnum*10 + num%10;
			num = num/10;
		}
		System.out.println("Reversed number is "+revnum);
	}
}
