package question;

import helper.ResultHelper;
import helper.TimeHelper;
import java.io.File;
import java.util.Scanner;

public class Question081 {
	static int result, size = 80, border = size - 1, matrix[][];

	public static void main(String[] args) {
		TimeHelper.start();
		matrix = new Question081().parseFile();
		go();
		ResultHelper.printOut("Result is " + result);
		TimeHelper.stop();
	}

	int[][] parseFile() {
		int matrix[][] = new int[size][size], i = 0, j;
		File file = new File(getClass().getClassLoader().getResource("p081_matrix.txt").getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				j = 0;
				for (String val : line.split(",")) {
					matrix[i][j++] = Integer.parseInt(val);
				}
				i++;
			}
			scanner.close();
		} catch (Exception e) {
			//
		}
		return matrix;
	}

	static void go() {
		for (int i = border; i >= 0; i--) {
			for (int j = border; j >= 0; j--) {
				matrix[i][j] += Math.min(getMatrixValue(i, j + 1), getMatrixValue(i + 1, j));
			}
		}
		result = matrix[0][0] - Integer.MAX_VALUE;
	}

	static int getMatrixValue(int i, int j) {
		try {
			return matrix[i][j];
		} catch (Exception e) {
			return Integer.MAX_VALUE;
		}
	}
}