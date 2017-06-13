package Basic;

public class Factorial {
	public static void main(String[] args) {
		System.out.println("Please provide number to get factorial");
		int n = 6;
		int fact = 1;
		for(int i=n;i>=1;i--) {
			fact = fact*i;
		}
		System.out.println("factorial of " +n +" is " +fact);
	}
}
