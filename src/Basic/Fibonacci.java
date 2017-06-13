package Basic;

public class Fibonacci {
	public static void main(String[] args){
		int[] fibo = new int[10];
		fibo[0] = 1;
		fibo[1] = 1;
		for(int i=2;i<fibo.length;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		for(int j=0;j<fibo.length;j++) {
			System.out.print(fibo[j]);
			if(j!=fibo.length-1)
			System.out.print(", ");
		}
	}
}
