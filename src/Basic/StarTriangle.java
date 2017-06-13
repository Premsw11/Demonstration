package Basic;

public class StarTriangle {
public static void main(String[] args) {
	int i;
	int j;
	int lr = 10;  // last row number
	for(i=1;i<=lr;i++) {
		// for loop left spaces
		for(int ls=i;ls<lr;ls++){
			System.out.print(" ");
		}
		// for loop * printing
		for(j=1;j<2*i;j++){
			System.out.print("*");
		}
		// for loop right spaces
		for(int rs=i;rs<lr;rs++){
			System.out.print("");
		}
		System.out.println();
	}
}
}
