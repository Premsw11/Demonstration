package Basic;
//This program validates that a number is prime or not
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println("Please provide a number to check for prime");
		// Scanner class to take input from user
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int rem = 0;
		boolean flag = true;
		for(int i=2; i<=Math.sqrt(num);i++) {
			rem = num%i;
			if(rem!=0)
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		if(flag==true)
			System.out.println("number is prime number");
		else 
			System.out.println("number is not a prime number");
		
	}
}
