package Basic;

import java.io.UnsupportedEncodingException;

public class Encoding {
	// This program does encoding of a String into byte sequence an then decodes again into String 
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "I am Prem\n suwalka have work experience of 2 years\t in Wipro";
		System.out.println("size of str  is"+str.length());
		String str1 = new String(str.replaceAll("[\n\t]", ""));
		System.out.println("size of str1  is"+str1.length());
		System.out.println("String is "+str);
		System.out.println("String1 is "+str1);
		byte[] encoded = str1.getBytes("US-ASCII");
		System.out.println("encoded string is "+encoded);
		String decoded = new String(encoded, "US-ASCII");
		System.out.println("decoded is "+decoded);
	}

}
