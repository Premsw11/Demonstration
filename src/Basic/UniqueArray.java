package Basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// To remove duplicate elements from an array and print unique array
public class UniqueArray {

	public static void main(String[] args) {
		List<String>  ar = new ArrayList<String>();
		ar.add(0, "Prem");
		ar.add(1, "Prakash");
		ar.add(2, "Suwalka");
		ar.add(3, "Prem");
		
		Set<String> s = new HashSet<String>(ar);
		List<String>  uniqar = new ArrayList<String>(s);
		for(String str : uniqar) {
			System.out.println(str);
		}
		
	}

}
