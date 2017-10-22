package Basic;
// This program return two maximum values of a series
import java.util.ArrayList;

public class TwoMaxArray {
public static void main(String[] args) {
	ArrayList<Integer> li = new ArrayList<Integer>();
	for(int i=1; i<10; i++) {
		li.add(Integer.valueOf(i));
	}
	
	li.add(9, 15);
	li.add(10, 65);
	li.add(11, 98);
	li.add(12, 32);
	li.add(13, 6);
	li.add(14, 60);
	for(Integer l : li) {    // To print all the values
		System.out.print(l);
		System.out.print(", ");
	}
	int max1 = 0;
	int max2 = 0;
	for(Integer l : li) {
		if(max1 > l);
		else {
			max2 = max1;
			max1 = l;
		}
	}
	System.out.println();
	System.out.println("max is "+max1);
	System.out.println("max2 is "+max2);
}
}
