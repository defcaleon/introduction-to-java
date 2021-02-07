package com.website.part2.main;

import java.util.Random;

//подключаю класс Main из-за методов для работы с массивами
import com.website.part1.main.Main;

public class Part2 {

	public static void shellSort(int[] arr, boolean direction) {

		int n = arr.length;
		for (int step = n / 2; step > 0; step /= 2) {

			for (int i = step; i < n; i++) {

				if (direction) {
					for (int j = i - step; j >= 0 && arr[j] > arr[j + step]; j -= step) {

						int x = arr[j];
						arr[j] = arr[j + step];
						arr[j + step] = x;
					}
				} else {
					for (int j = i - step; j >= 0 && arr[j] < arr[j + step]; j -= step) {

						int x = arr[j];
						arr[j] = arr[j + step];
						arr[j + step] = x;
					}
				}
			}
		}

	}

//arr - сам массив где производить поиск
//direction - true-по вохрастанию  false- по убыванию
// num -число которое необходимо вставить
//maxIndex- максимальный индекс подмассива в котором нужно искать место для вставки
	private static int binarySearch(int[] arr, int numToInsert, int maxIndex) {

		int left = 0;
		int right = maxIndex;
		boolean flag = true;
		while (flag) {

			int mid = (left + right) / 2;
			if (numToInsert == arr[mid]) {
				return mid + 1;
			} else {

				if (numToInsert > arr[mid]) {

					left = mid + 1;
				} else {

					right = mid - 1;
				}
				if (left > right) {
					return right + 1;
				}
			}

		}
		return 1;
	}

	public static void insertSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int index = binarySearch(arr, arr[i], i - 1);
			int temp = arr[i];

			// System.out.println("ind= "+index+" max len = "+ i);

			for (int j = index; j <= i; j++) {
				int temp2 = arr[j];
				arr[j] = temp;
				temp = temp2;
			}
			// Main.showArr(arr);

		}
	}

	// возвращает количество перестановок
	public static int bubbleSort(int[] arr, boolean direction) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {

				if (direction) {

					if (arr[j] > arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						counter++;
					}
				} else {
					if (arr[j] < arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						counter++;
					}

				}
			}
		}
		return counter;
	}

	public static void selectionSort(int[] arr, boolean direction) {

		if (arr.length == 0) {
			return;
		}

		for (int i = 0; i < arr.length - i; i++) {

			int min = arr[i];
			int minIndex = i;
			int max = arr[i];
			int maxIndex = i;

			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[j] > max) {
					max = arr[j];
					maxIndex = j;
				} else {
					if (arr[j] < min) {
						min = arr[j];
						minIndex = j;
					}
				}

			}

			// System.out.println("max= "+ max+" ind = "+ maxIndex+" min = "+min+" ind
			// "+minIndex);
			if (direction) {

				arr[maxIndex] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = max;

				if (minIndex == arr.length - i - 1) {
					minIndex = maxIndex;
				}

				arr[minIndex] = arr[i];
				arr[i] = min;
			} else {
				arr[minIndex] = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = min;

				if (maxIndex == arr.length - i - 1) {
					maxIndex = minIndex;
				}

				arr[maxIndex] = arr[i];
				arr[i] = max;
			}

			// Main.showArr(arr);

		}
	}

	public static void showMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			Main.showArr(matrix[i]);
		}

	}

	public static void showMatrix(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			Main.showArr(matrix[i]);
		}

	}

	public static void randInitMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			Main.randInitArr(matrix[i]);
		}

	}

//Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.	
//
//решил делать не для квадратичной матрицы, решение что-то разошлось, пересмотри, может придумаешь покороче
//P.S. больше не ищи ошибку , потому что всё правильно вывод столбцов в строку...
	private static void printColumn(int[][] matrix, int columnIndex) {

		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i].length > columnIndex) {
				System.out.print(matrix[i][columnIndex] + " ");
			}

		}
		System.out.println();
	}

	private static int firstNumberInColumn(int[][] matrix, int columnIndex) {

		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i].length > columnIndex) {
				return matrix[i][columnIndex];
			}

		}
		return 0;

	}

	private static int lastNumberInColumn(int[][] matrix, int columnIndex) {

		int lastNumber = 0;
		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i].length > columnIndex) {
				lastNumber = matrix[i][columnIndex];
			}

		}
		return lastNumber;

	}

	private static int largestLine(int[][] matrix) {

		if (matrix == null) {
			return -1;
		}
		int max = matrix[0].length;
		for (int i = 1; i < matrix.length; i++) {
			if (max < matrix[i].length) {
				max = matrix[i].length;
			}
		}
		return max;
	}

	public static void task1() {

		final int SIZE = 5;

		int[][] matrix = new int[SIZE][];
		Random rand = new Random();

		for (int i = 0; i < SIZE; i++) {
			matrix[i] = new int[rand.nextInt(10)];
		}

		randInitMatrix(matrix);
		showMatrix(matrix);
		System.out.println("=====================");

		int numOfIter = largestLine(matrix);
		for (int i = 0; i < numOfIter; i += 2) {
			int firstNum = firstNumberInColumn(matrix, i);
			int lastNum = lastNumberInColumn(matrix, i);
			// System.out.println("firstNum= " + firstNum + " lastNum= " + lastNum);
			if (firstNum > lastNum) {
				printColumn(matrix, i);
			}

		}
	}

//Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
	public static void task2() {

		final int SIZE = 5;

		int[][] matrix = new int[SIZE][SIZE];

		randInitMatrix(matrix);
		showMatrix(matrix);

		System.out.println("=====================");

		System.out.print("main diagonal ");

		for (int i = 0; i < matrix.length; i++) {
			System.out.printf("%2d ", matrix[i][i]);

		}

		System.out.println();
		System.out.print("side diagonal ");

		for (int i = 0; i < matrix.length; i++) {
			System.out.printf("%2d ", matrix[i][SIZE - i - 1]);

		}
		System.out.println();
	}

//Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
	public static void task3() {
		final int SIZE = 5;

		int[][] matrix = new int[SIZE][];
		Random rand = new Random();

		for (int i = 0; i < SIZE; i++) {
			matrix[i] = new int[rand.nextInt(10)];
		}

		randInitMatrix(matrix);
		showMatrix(matrix);

		int k;
		do {
			k = Main.inputInt("enter k>>");
		} while (k <= 0);
		k--;

		int p;
		do {
			p = Main.inputInt("enter p>>");
		} while (p <= 0);
		p--;

		System.out.println("K-line");
		if (k >= matrix.length) {
			System.out.println("Error. out-of-range");
		} else {
			Main.showArr(matrix[k]);
		}

		System.out.println("P-column");
		printColumn(matrix, p);
	}

// Сформировать квадратную матрицу порядка n по заданному образцу
// нечётные строки от 1 доn
//чётные от n до 1
	public static void task4() {
		final int SIZE = 6;

		int[][] matrix = new int[SIZE][SIZE];

		boolean flag = true;
		for (int i = 0, counter; i < matrix.length; i++) {

			if (flag) {
				counter = 1;
			} else {
				counter = SIZE;
			}

			for (int j = 0; j < matrix[i].length; j++) {

				matrix[i][j] = counter;
				if (flag) {
					counter++;
				} else {
					counter--;
				}
			}

			flag = !flag;
		}

		showMatrix(matrix);
	}

//сделать красивую матрицу ( я не знаю как описать таск, запусти )
	public static void task5() {

		final int SIZE = 6;

		int[][] matrix = new int[SIZE][SIZE];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - i; j++) {
				matrix[i][j] = i + 1;
			}
		}

		showMatrix(matrix);

	}

	public static void task6() {

		final int SIZE = 6;

		int[][] matrix = new int[SIZE][SIZE];

		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0 + i; j < matrix[i].length - i; j++) {
				matrix[i][j] = 1;
			}
		}
		for (int i = matrix.length / 2; i < matrix.length; i++) {
			for (int j = matrix.length - i - 1; j < i + 1; j++) {
				matrix[i][j] = 1;
			}
		}

		showMatrix(matrix);

	}

// Сформировать квадратную матрицу порядка N по правилу и подсчитать количество положительных элементов в ней.
// A[i][j]=sin((i^2-j^2)/N);
	private static double calcFunc(int i, int j, int N) {

		return Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / N);

	}

	public static void task7() {

		final int SIZE = 6;

		double[][] matrix = new double[SIZE][SIZE];

		int counter = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = calcFunc(i, j, SIZE);
				if (matrix[i][j] > 0) {
					counter++;
				}

			}
		}

		showMatrix(matrix);
		System.out.println("num of positive numbers = " + counter);
	}

//В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
//на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
//пользователь с клавиатуры.
	public static void task8() {

		final int SIZE = 6;

		int[][] matrix = new int[SIZE][SIZE];
		randInitMatrix(matrix);

		showMatrix(matrix);

		int column1;
		do {
			column1 = Main.inputInt("Enter first column>>");

		} while (column1 <= 0 || column1 > SIZE);

		int column2;
		do {
			column2 = Main.inputInt("Enter second column>>");

		} while (column2 <= 0 || column2 > SIZE);

		if (column1 != column2) {
			column1--;
			column2--;
			for (int i = 0; i < SIZE; i++) {

				int temp = matrix[i][column1];
				matrix[i][column1] = matrix[i][column2];
				matrix[i][column2] = temp;
			}
		}

		showMatrix(matrix);

	}

//Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
//столбец содержит максимальную сумму
	public static void task9() {

		final int SIZE = 5;

		int[][] matrix = new int[SIZE][];
		Random rand = new Random();

		for (int i = 0; i < SIZE; i++) {
			matrix[i] = new int[rand.nextInt(10)];
		}

		randInitMatrix(matrix);
		showMatrix(matrix);

		int numOfCol = largestLine(matrix);
		int[] sumArr = new int[numOfCol];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sumArr[j] += matrix[i][j];
			}
		}

		System.out.println("=====================");
		Main.showArr(sumArr);

		int max = sumArr[0];
		int index = 0;

		for (int i = 1; i < sumArr.length; i++) {
			if (sumArr[i] > max) {
				max = sumArr[i];
				index = i;
			}
		}
		System.out.println("max sum is " + max + " in column " + (index + 1));

	}

//Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
//которых число 5 встречается три и более раз.
	public static void task11() {
		int[][] matrix = new int[10][20];
		Random rand = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(16);
			}
		}

		showMatrix(matrix);
		System.out.println("=====================");
		System.out.print("Lines where 5 occurs 3 or more times: ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0, counter = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 5) {
					counter++;
					if (counter == 3) {
						System.out.print((i + 1) + " ");
					}
				}
			}
		}

		System.out.println();

	}

//Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
	public static void task12() {
		final int SIZE = 5;

		int[][] matrix = new int[SIZE][SIZE];
		randInitMatrix(matrix);

		showMatrix(matrix);
		System.out.println("=====================");

		for (int i = 0; i < matrix.length; i++) {
			selectionSort(matrix[i], true);
		}
		showMatrix(matrix);
		System.out.println("=====================");

		for (int i = 0; i < matrix.length; i++) {
			selectionSort(matrix[i], false);
		}
		showMatrix(matrix);
	}

//Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов	
	public static void task13() {

		final int SIZE = 5;

		int[][] matrix = new int[SIZE][SIZE];
		randInitMatrix(matrix);

		showMatrix(matrix);

		for (int numOfCol = 0; numOfCol < SIZE; numOfCol++) {

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE - i - 1; j++) {

					if (matrix[j][numOfCol] > matrix[j + 1][numOfCol]) {

						int temp = matrix[j][numOfCol];
						matrix[j][numOfCol] = matrix[j + 1][numOfCol];
						matrix[j + 1][numOfCol] = temp;
					}

				}
			}
		}
		System.out.println("=====================");
		showMatrix(matrix);

		for (int numOfCol = 0; numOfCol < SIZE; numOfCol++) {

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE - i - 1; j++) {

					if (matrix[j][numOfCol] < matrix[j + 1][numOfCol]) {

						int temp = matrix[j][numOfCol];
						matrix[j][numOfCol] = matrix[j + 1][numOfCol];
						matrix[j + 1][numOfCol] = temp;
					}

				}
			}
		}
		System.out.println("=====================");
		showMatrix(matrix);

	}

//. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
// единиц равно номеру столбца.
	public static void task14() {

		final int m = 5;
		final int n = 5;

		int[][] matrix = new int[m][n];
		Random rand = new Random();

		// i - column number
		for (int i = 0; i < n; i++) {

			if (i <= m) {

				int j = i + 1;
				while (j > 0) {
					int num = rand.nextInt(m);
					if (matrix[num][i] == 0) {
						matrix[num][i] = 1;
						j--;
					}

				}
			}
		}
		showMatrix(matrix);

	}

//Найдите наибольший элемент матрицы и заменить все нечетные элементы на него
	public static void task15() {

		final int SIZE = 5;

		int[][] matrix = new int[SIZE][];
		Random rand = new Random();

		for (int i = 0; i < SIZE; i++) {
			matrix[i] = new int[rand.nextInt(10)];
		}

		randInitMatrix(matrix);
		showMatrix(matrix);

		int max = -10000;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}

		for (int i = 0; i < matrix.length; i += 2) {
			for (int j = 0; j < matrix[i].length; j += 2) {
				matrix[i][j] = max;
			}
		}
		System.out.println("=====================");
		showMatrix(matrix);

	}

//Магическим квадратом порядка n  
	// Очень интересная и занимательная задачка :)
	private static boolean upOverflow(int y, int upBorder) {

		return y < upBorder ? true : false;

	}

	private static boolean rightOverflow(int x, int rightBorder) {
		return x > rightBorder ? true : false;
	}

	private static boolean isEmpty(int x, int y, int[][] matrix) {

		return matrix[x][y] == 0 ? true : false;
	}

	// возвращает последнее число которое было помещено в магический квадрат
	// startX-левая боковая граница матрицы
	// startУ-левая верхняя граница матрицы
	// endX-правая боковая граница матрицы
	// endУ-правая верхняя граница матрицы
	// matrix - матрица в которую будут помещены цифры
	// startNumber число с которого будет начато размещение
	private static int magicSquare(int startX, int startY, int endX, int endY, int[][] matrix, int startNumber) {

		int n = endX - startX + 1;

		int i = startY;
		int j = startX + n / 2;

		for (int num = 1; num <= n * n; num++) {

			if (!isEmpty(i, j, matrix)) {

				int tempI = i;
				int tempJ = j;

				i--;
				j++;

				if (upOverflow(i, startY)) {
					i = endY;
				}

				if (rightOverflow(j, endX)) {
					j = startX;
				}

				if (!isEmpty(i, j, matrix)) {
					i = ++tempI;
					j = tempJ;

				}

			}

			matrix[i][j] = startNumber++;

		}
		return startNumber;
	}

	private static void swapElementsInOneRow(int firstRowIndex, int secondRowIndex, int start, int[][] matrix) {

		int temp = matrix[firstRowIndex][start];
		matrix[firstRowIndex][start] = matrix[secondRowIndex][start];
		matrix[secondRowIndex][start] = temp;

	}

	private static void fillBoolMatrix(int startX, int startY, int length, boolean[][] matrix) {
		for (int i = startY; i < startY + length; i++) {
			for (int j = startX; j < startX + length; j++) {
				matrix[i][j] = true;
			}
		}
	}

	private static int lastNumInNumArr(boolean[] arr) {

		int i = arr.length - 1;
		while (i >= 0) {
			if (!arr[i]) {

				arr[i] = !arr[i];
				return i;
			}
			i--;
		}
		return -1;
	}

	public static void task16() {

		int n;
		do {
			n = Main.inputInt("n>>");
		} while (n <= 0);

		int[][] matrix = new int[n][n];

		int magicNum = (n * (n * n + 1)) / 2;
		System.out.println("Sum in all lines/columns/diagonals = " + magicNum);

		if (n % 2 == 1) {

			magicSquare(0, 0, n - 1, n - 1, matrix, 1);

		} else {
			if (n == 2) {
				System.out.println("Impossible to create");
			} else {

				if (n % 2 == 0 && n % 4 != 0) {

					int halfN = n / 2;
					int numToInput = 1;
					numToInput = magicSquare(0, 0, halfN - 1, halfN - 1, matrix, numToInput);
					numToInput = magicSquare(halfN, halfN, n - 1, n - 1, matrix, numToInput);
					numToInput = magicSquare(halfN, 0, n - 1, halfN - 1, matrix, numToInput);
					magicSquare(0, halfN, halfN - 1, n - 1, matrix, numToInput);

					int line = 0;
					swapElementsInOneRow(line++, halfN, 0, matrix);
					for (int i = 1; i < halfN - 1; i++) {
						swapElementsInOneRow(line++, halfN + i, 1, matrix);
					}
					swapElementsInOneRow(line, n - 1, 0, matrix);

					if (n > 6) {

						int counter = 0;
						for (int i = 6; i < n; i += 4) {
							counter++;
						}

						for (int i = 0; i < counter; i++) {
							for (int j = 0; j < halfN; j++) {
								for (int k = -1; k < 1; k++) {
									swapElementsInOneRow(j, halfN + j, halfN + k, matrix);
								}

							}
						}
					}

				} else {
					boolean[][] boolMatrix = new boolean[n][n];
					boolean[] numArr = new boolean[n * n + 1];

					int n4 = n / 4;
					fillBoolMatrix(0, 0, n4, boolMatrix);
					fillBoolMatrix(n - n4, 0, n4, boolMatrix);
					fillBoolMatrix(0, n - n4, n / 4, boolMatrix);
					fillBoolMatrix(n - n4, n - n4, n / 4, boolMatrix);
					fillBoolMatrix(n4, n4, n4 * 2, boolMatrix);

					for (int i = 0, counter = 1; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (boolMatrix[i][j]) {
								matrix[i][j] = counter;
								numArr[counter] = true;
							}
							counter++;

						}

					}

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (!boolMatrix[i][j]) {
								matrix[i][j] = lastNumInNumArr(numArr);
							}
						}
					}
				}
			}

		}

		showMatrix(matrix);
	}

	// Заданы два одномерных массива с различным количеством элементов и натуральное
	// число k. Объединить их в
	// один массив, включив второй массив между k-м и (k+1) - м элементами первого,
	// при этом не используя
	// дополнительный массив.
	public static void sortTask1() {

		Random rand = new Random();

		int[] arr1 = new int[200];
		int[] arr2 = new int[100];

		int faktLen1 = rand.nextInt(10) + 1;
		int k = rand.nextInt(faktLen1);
		System.out.println("k=" + (k + 1));

		for (int i = 0; i < faktLen1; i++) {
			arr1[i] = rand.nextInt(100);
			System.out.printf("%2d ", arr1[i]);
		}

		System.out.println();
		System.out.println("=====================");

		int faktLen2 = rand.nextInt(10) + 1;

		for (int i = 0; i < faktLen2; i++) {
			arr2[i] = rand.nextInt(100);
			System.out.printf("%2d ", arr2[i]);
		}

		System.out.println();
		System.out.println("=====================");

		for (int i = k + 1, index = 0; i < faktLen1 + faktLen2; i++) {

			int temp = arr2[index];
			arr2[index++] = arr1[i];
			arr1[i] = temp;

		}

		for (int i = k + faktLen2 + 1, index = 0; index < faktLen1 - k + 1; i++) {

			arr1[i] = arr2[index++];
		}
		for (int i = 0; i < faktLen1 + faktLen2; i++) {

			System.out.printf("%2d ", arr1[i]);
		}

		System.out.println();

	}

//даны две  последовательности действительных чисел
// a1 <= a2 <=...<=an  и b1<= b2<=... <= bm
//Образовать из них новую последовательность
//чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.

	private static void rightShiftWithInput(int numToInput, int startIndex, int[] arr) {

		for (int i = startIndex; i < arr.length; i++) {

			int temp = arr[i];
			arr[i] = numToInput;
			numToInput = temp;

		}
	}

	public static void sortTask2() {

		int[] arr1 = new int[20];
		int[] arr2 = { 1, 2, 3, 40, 100 };

		final int SIZE = 5;

		for (int i = 1, index = 0; i < 10; i += 2) {
			arr1[index++] = i;
		}

		for (int i = 0; i < SIZE; i++) {

			System.out.printf("%2d ", arr1[i]);
		}
		System.out.println();

		Main.showArr(arr2);

		int arr2Index = 0;
		int arr1Index = 0;

		int size = SIZE;
		while (arr2Index != arr2.length) {

			if (arr1[arr1Index] > arr2[arr2Index]) {

				rightShiftWithInput(arr2[arr2Index], arr1Index, arr1);
				size++;
				arr2Index++;

			} else {
				if (arr1Index >= size) {
					arr1[arr1Index] = arr2[arr2Index];
					arr2Index++;
				}

				arr1Index++;

			}
		}

		for (int i = 0; i < SIZE + arr2.length; i++) {

			System.out.printf("%2d ", arr1[i]);
		}
		System.out.println();

	}

//. Пусть даны две неубывающие последовательности действительных чисел
// a1 <= a2 <=...<=an  и b1<= b2<=... <= bm
//	Требуется указать те места, на которые нужно вставлять элементы последовательности
//	b1<= b2<=... <= bm в первую
//	последовательность так, чтобы новая последовательность оставалась возрастающей.

	private static int placeToInputMessage(double numToInp, int start, double[] arr) {
		while (start < arr.length) {

			if (arr[start] > numToInp) {
				// System.out.println(arr[start]+" "+numToInp);
				if (start == 0) {
					System.out.printf(" U need to Inp this num first  \n");
					return start;
				} else {
					System.out.printf(" U need to Inp this num after %.1f \n", arr[start - 1]);
					return start;
				}
			}
			start++;
		}
		System.out.printf(" U need to Inp this num after %.1f \n", arr[arr.length - 1]);
		return start;

	}

	public static void sortTask7() {

		double[] arr1 = { 1.2, 1.6, 2.2, 2.8, 3.2 };
		double[] arr2 = { 1.1, 1.4, 2.4, 3.2, 3.4, 4 };

		for (int i = 0, start = 0; i < arr2.length; i++) {
			start = placeToInputMessage(arr2[i], start, arr1);

		}
	}

//	Даны дроби  p1/q1, p2/q2, ... ,pn/qn
// Составить программу, которая приводит эти дроби к общему
// знаменателю и упорядочивает их в порядке возрастания.

	public static int NOD(int a, int b) {

		if (a == 0 || b == 0) {
			return 0;
		}

		int biggest = a > b ? a : b;
		int smallest = a > b ? b : a;

		int remainder = smallest;
		do {

			remainder = biggest % smallest;

			if (remainder == 0) {
				return smallest;
			}

			biggest = smallest;
			smallest = remainder;

		} while (true);

	}

	public static int NOK(int a, int b) {

		int nod = NOD(a, b);
		if (nod == 0) {
			return 0;
		} else {
			return (a * b) / NOD(a, b);
		}
	}

	private static int commonDenominator(Fraction[] arr) {

		if (arr.length < 0) {
			System.out.println("array is null");
			return 0;
		} else {
			if (arr.length == 0) {
				return arr[0].getDenominator();
			} else {
				int firstNOK = NOK(arr[0].getDenominator(), arr[1].getDenominator());

				for (int i = 2; i < arr.length; i++) {
					firstNOK = NOK(firstNOK, arr[i].getDenominator());
				}

				return firstNOK;
			}
		}

	}

	private static void newNumirator(Fraction[] arr, int nok) {
		for (int i = 0, multiplier; i < arr.length; i++) {

			multiplier = nok / arr[i].getDenominator();
			arr[i].setNumerator(arr[i].getNumerator() * multiplier);
			arr[i].setDenominator(nok);
		}
	}

	private static void fractionSort(Fraction[] arr) {

		if (arr.length == 0) {
			return;
		}

		for (int i = 0; i < arr.length - i; i++) {

			int min = arr[i].getNumerator();
			int minIndex = i;
			int max = arr[i].getNumerator();
			int maxIndex = i;

			for (int j = i + 1; j < arr.length - i; j++) {
				if (arr[j].getNumerator() > max) {
					max = arr[j].getNumerator();
					maxIndex = j;
				} else {
					if (arr[j].getNumerator() < min) {
						min = arr[j].getNumerator();
						minIndex = j;
					}
				}

			}

			arr[maxIndex].setNumerator(arr[arr.length - i - 1].getNumerator());
			arr[arr.length - i - 1].setNumerator(max);

			if (minIndex == arr.length - i - 1) {
				minIndex = maxIndex;
			}

			arr[minIndex].setNumerator(arr[i].getNumerator());
			arr[i].setNumerator(min);

		}
	}

	private static void showFractionArr(Fraction[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i].show();
		}

		System.out.println();

	}

	public static void sortTask8() {

		Fraction[] arr = { new Fraction(3, 4), new Fraction(2, 3), new Fraction(2, 5), new Fraction(2, 7),
				new Fraction(2, 10) };

		showFractionArr(arr);
		newNumirator(arr, commonDenominator(arr));

		showFractionArr(arr);

		fractionSort(arr);

		showFractionArr(arr);

	}

	public static void main(String[] args) {

		sortTask8();

	}

}
