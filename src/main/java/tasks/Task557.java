package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task557 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int matrixesCount = scanner.nextInt();
		int matrixesSize = scanner.nextInt();
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		int p = scanner.nextInt();

		if (i > matrixesSize || j > matrixesSize || i < 1 || j < 1 || matrixesSize < 1 || matrixesCount < 1) {
			//return;
		}
		int[][][] matrixes = new int[matrixesCount][matrixesSize][matrixesSize];
		for (int k = 0; k < matrixesCount; k++) {
			matrixes[k] = fillMatrix(reader, matrixesSize);
		}
		int[][] matrix = matrixes[0];
		if (matrixesCount > 1) {
			for (int k = 1; k < matrixes.length; k++) {
				matrix = multiplyMatrixes(matrix, matrixes[k], p, i - 1);
			}
		}
		System.out.println(matrix[i - 1][j - 1]);

	}

	private static int[][] fillMatrix(BufferedReader reader, int matrixesSize) throws IOException {
		int[][] matrix = new int[matrixesSize][matrixesSize];
		String s;
		StringTokenizer tokenizer;
		for (int i = 0; i < matrixesSize; i++) {
			s = reader.readLine();

			while (s.isEmpty()) {
				s = reader.readLine();
			}
			s = s.trim();
			for (int j = 0; j < matrixesSize; j++) {
				tokenizer = new StringTokenizer(s, " ");
				while (!tokenizer.hasMoreTokens()) {
					s = reader.readLine().trim();
					tokenizer = new StringTokenizer(s, " ");
				}
				System.out.println(tokenizer.countTokens());
				matrix[i][j] = Integer.valueOf(tokenizer.nextToken().trim());
			}
		}
		return matrix;
	}

	private static int multiplyMatrixElement(int i, int j, int[][] matrix1, int[][] matrix2) {
		int rez = 0;
		for (int z = 0; z < matrix1.length; z++) {
			rez += (matrix1[i][z] * matrix2[z][j]);
		}
		return rez;
	}

	private static int[][] multiplyMatrixes(int[][] matrix1, int[][] matrix2, int p, int i) {
		int size = matrix1.length;
		int[][] matrix = new int[size][size];
		for (int j = 0; j < size; j++) {
			matrix[i][j] = (multiplyMatrixElement(i, j, matrix1, matrix2) % p);
		}
		return matrix;

	}
}

/*	3 2
1 2
239

1 2
3 4

4 2
1 3

1 2
2 1*/


/**
 * import java.io.InputStreamReader;
 * import java.util.ArrayList;
 * import java.util.List;
 * import java.util.Scanner;
 * <p>
 * public class GPSolutions.tasks.Task557 {
 * public static void main(String[] args) {
 * try (Scanner scanner = new Scanner(new InputStreamReader(System.in))) {
 * int matrixesCount = scanner.nextInt();
 * int matrixesSize = scanner.nextInt();
 * int i = scanner.nextInt();
 * int j = scanner.nextInt();
 * int p = scanner.nextInt();
 * <p>
 * if (i > matrixesSize || j > matrixesSize || i < 1 || j < 1 || matrixesSize < 1 || matrixesCount < 1) {
 * return;
 * }
 * <p>
 * List<int[][]> list = new ArrayList<>();
 * while (list.size() < matrixesCount) {
 * list.add(fillMatrix(scanner, matrixesSize));
 * }
 * int[][] matrix = list.get(0);
 * if (matrixesCount > 1) {
 * for (int k = 1; k < list.size(); k++) {
 * if (k == list.size() - 1) {
 * matrix[i - 1][j - 1] = multiplyMatrixElement(i - 1, j - 1, matrix, list.get(k));
 * } else {
 * matrix = multiplyMatrixes(matrix, list.get(k), p, i - 1);
 * }
 * }
 * }
 * System.out.println(matrix[i - 1][j - 1]);
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 * <p>
 * private static int[][] fillMatrix(Scanner scanner, int matrixesSize) {
 * int[][] matrix = new int[matrixesSize][matrixesSize];
 * for (int i = 0; i < matrixesSize; i++) {
 * for (int j = 0; j < matrixesSize; j++) {
 * matrix[i][j] = scanner.nextInt();
 * }
 * }
 * return matrix;
 * }
 * <p>
 * private static int multiplyMatrixElement(int i, int j, int[][] matrix1, int[][] matrix2) {
 * int rez = 0;
 * for (int z = 0; z < matrix1.length; z++) {
 * rez += (matrix1[i][z] * matrix2[z][j]);
 * }
 * return rez;
 * }
 * <p>
 * private static int[][] multiplyMatrixes(int[][] matrix1, int[][] matrix2, int p, int i) {
 * int size = matrix1.length;
 * int[][] matrix = new int[size][size];
 * for (int j = 0; j < size; j++) {
 * matrix[i][j] = (multiplyMatrixElement(i, j, matrix1, matrix2) % p);
 * }
 * return matrix;
 * <p>
 * }
 * }
 * <p>
 * /*	3 2
 * 1 2
 * 239
 * <p>
 * 1 2
 * 3 4
 * <p>
 * 4 2
 * 1 3
 * <p>
 * 1 2
 * 2 1
 */