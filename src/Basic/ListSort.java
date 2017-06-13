package Basic;
// TO sort an array
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListSort {

	public static void main(String[] args) {
		List<String> ar = new ArrayList<String>();
		
			ar.add(0, "Prem");
			ar.add(1, "Prakash");
			ar.add(2, "Suwalka");
			ar.add(3, "Prem");
		
		for(String str : ar) {
			System.out.println(str);
		}
			Collections.sort(ar);    // To sort the array  
			//String[] can be sorted using Arrays.sort(strarray)
			System.out.println("After sorting");
			for(String str : ar) {
				System.out.println(str);
			}	
	}

}
