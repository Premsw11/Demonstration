package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.xalan.xsltc.compiler.sym;

import com.google.common.primitives.Ints;

public class FilterDuplicateElementFromAnArray {

	public static void main(String[] args) {
		FilterDuplicateElementFromAnArray fde = new FilterDuplicateElementFromAnArray();
		System.out.println("The duplicacy is removed using basic java concepts");
		fde.withoutCollection();
		System.out.println("The duplicacy is removed using Collections framework");
		fde.usingHashSet();
	}

	public void withoutCollection() {
		int[] arr = new int[] {1,2,3,2,2,5,7,3,6};
		int[] uniqueArr = new int[arr.length];
		int count = 0;

		for(int i = 0; i < arr.length; i++) {
			int num = arr[i];
			boolean flag = false;
			flag = flagVerify(uniqueArr, num);
			if(flag) {
				//skip
			}
			else {
				uniqueArr[count] = num;
				count++;
			}
		}
		for(int j = 0; j < count; j++) {
			System.out.print(uniqueArr[j]);
			System.out.print(", ");
		}
		System.out.println();
//		System.out.println(Ints.asList(uniqueArr)); // Converts an int[] into ArrayList<Integer>

	}


	public boolean flagVerify(int[] uniqueArr, int num) {
		boolean flag = false;
		for(int i = 0; i < uniqueArr.length; i++) {
			if(uniqueArr[i] == num) {
				flag = true;
				break;
			}
		}
		return flag;
	}


	public void usingHashSet() {
		int[] arr = new int[] {1,2,3,2,2,5,7,3,6};
		HashSet<Integer> ss = new HashSet<Integer>();

		for(int i = 0; i < arr.length; i++) {
			ss.add(arr[i]);
		}

		ArrayList<Integer> al = new ArrayList<Integer>(ss);
		System.out.println(al);

	}



}
