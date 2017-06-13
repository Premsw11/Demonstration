package Pack1;

public class Stringdemo {

	public static void main(String[] args) {
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1+ "," + str2);
		System.out.println(str1.hashCode()+ "," + str2.hashCode());
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		str1 = str1+str2;
		System.out.println(str1 + "," + str2);
		System.out.println(str1.hashCode()+ "," + str2.hashCode());
	}

}
