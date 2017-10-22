package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortListofStrings {

	public static void main(String[] args) {
		SortListofStrings sf = new SortListofStrings();
		sf.sortStringUsingCollections(); 
		sf.sortStringUsingbasicJava();
		sf.trying();
	}
	
	public void sortStringUsingCollections() {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Prem");
		al.add("Vikash");
		al.add("jay");
		al.add("Akash");
		System.out.println("Before sorting "+al);
		Collections.sort(al, String.CASE_INSENSITIVE_ORDER);
		System.out.println("After sorting "+al);
	}
	
	public void sortStringUsingbasicJava () {
		SortListofStrings sf = new SortListofStrings();
		String[] strArray = {"Prem", "vikash", "jay", "akash"};
		
		System.out.println("String Array before sorting ");
		sf.printArray(strArray);
		Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
		System.out.println("String Array after sorting ");
		sf.printArray(strArray);
	}
	public void printArray(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
	
	public void trying() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		String str = "Testvagrant";
		int length = str.length();
		for(int i = 0; i < length; i++) {
			char ch = str.charAt(i);
			int nextCharIndex = str.indexOf(ch, i+1);
			if(nextCharIndex == -1) {
				al.add(i, length-i);
			} 
			else {
				al.add(i, nextCharIndex-i);
			}
		}
		System.out.println(al);

	}

}
