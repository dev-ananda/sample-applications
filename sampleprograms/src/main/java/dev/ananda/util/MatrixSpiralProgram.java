package dev.ananda.util;

public class MatrixSpiralProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int[][] spiral = new int[n][n];
		int value = 1;
		int minCol = 0;
		int maxCol = n - 1;
		int minRow = 0;
		int maxRow = n - 1;
		int assignValue = 0;

		while (value <= n * n) {
			assignValue++;
			for (int i = minCol; i <= maxCol; i++) {
				spiral[minRow][i] = assignValue;
				value++;
			}
			for (int i = minRow + 1; i <= maxRow; i++) {
				spiral[i][maxCol] = assignValue;

				value++;
			}
			for (int i = maxCol - 1; i >= minCol; i--) {
				spiral[maxRow][i] = assignValue;

				value++;
			}
			for (int i = maxRow - 1; i >= minRow + 1; i--) {
				spiral[i][minCol] = assignValue;

				value++;
			}

			minCol++;
			minRow++;
			maxCol--;
			maxRow--;
		}

		for (int i = 0; i < spiral.length; i++) {
			for (int j = 0; j < spiral.length; j++) {
				System.out.print(spiral[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
