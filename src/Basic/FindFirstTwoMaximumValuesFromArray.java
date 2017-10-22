package Basic;

public class FindFirstTwoMaximumValuesFromArray {

	public static void main(String[] args) {
		int[] arr = {1, 34, 12, 43, 54, 33, 2};
		int max1 = 0;
		int max2 = 0;
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if(num >= max1) {
				max2 = max1;
				max1 = num;
			}
			if(max1 > num && num > max2) {
				max2 = num;
			}
		}
		System.out.println("max1 is "+max1);
		System.out.println("max2 is "+max2);
	}
}
