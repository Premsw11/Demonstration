	package Basic;

import java.util.Arrays;

public class TwoDimArrayWrap {

	public static void main(String[] args) {
		int[][] matrix = new int [3][3];
		matrix[0][0] = 1;  matrix[0][1] = 3;  matrix[0][2] = 5;
		matrix[1][0] = 4;  matrix[1][1] = 6;  matrix[1][2] = 8;
		matrix[2][0] = 5;  matrix[2][1] = 7;  matrix[2][2] = 9;
		//System.out.println("Matrix is =="+Arrays.asList(matrix));
		System.out.println("original matrix is");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t"); 
			}
			System.out.println();
		}
		
		int[][] mirrorMatrix = new int [3][3];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				mirrorMatrix[i][j] = matrix[i][matrix.length-j-1];
			}
		}
		
		System.out.println("mirror matrix is");
		for(int i = 0; i < mirrorMatrix.length; i++) {
			for(int j = 0; j < mirrorMatrix[i].length; j++) {
				System.out.print(mirrorMatrix[i][j] + "\t"); 
			}
			System.out.println();
		}

	}

}
