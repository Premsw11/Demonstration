package Basic;

import java.util.Scanner;

public class CommandLineArgument {
	public static void main(String[] args ) {
//		Scanner sc = new Scanner(System.in);
//		args[0] = sc.nextLine();
//		System.out.println(args[0]);
//		System.out.println(args[1]);
//		int a = Integer.parseInt(args[0]);
//		int b = Integer.valueOf(args[1]);
//		System.out.println(a+b);
//		System.out.println(args.length);
//		Integer I = new Integer(10);
//		int i = I;
//		int ival = I.intValue();
//		System.out.println("i=="+I);
//		System.out.println("ival=="+ival);
//		CommandLineArgument cd = new CommandLineArgument();
//		System.out.println(cd);
		
		String str = "I am working at Wipro";
		String[] st = str.split("\\s");
		StringBuilder sb = new StringBuilder();
		for(String s : st) {
			
			for(int i = 0; i < s.length() ; i++) {
				sb.append(s.charAt(s.length()-1-i));
			}
			sb.append(" ");
		}
		System.out.println(sb);
//		System.out.println(str.length());
//		System.out.println(str.replaceAll("\\s", "").length());
	}
}
