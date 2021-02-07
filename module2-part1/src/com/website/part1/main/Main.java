package com.website.part1.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

	//Общие Методы которые чаще всего понадобятся для работы с массивами
	public static int inputInt(String message) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.print(message);
		while (!in.hasNextInt()) {
			in.next();
			System.out.print(message);
		}
		return in.nextInt();

	}

	public static double inputDouble(String message) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		System.out.print(message);
		while (!in.hasNextDouble()) {
			in.next();
			System.out.print(message);
		}
		return in.nextDouble();

	}

	public static void randInitArr(int[] arr) {

		if (arr == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);

		}
	}

	public static void randInitArr(double[] arr) {
		if (arr == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(50) + rand.nextDouble();

		}
	}

	public static void showArr(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%2d ",arr[i]);
		}
		System.out.println();
	}

	public static void showArr(double[] arr) {

		if (arr == null) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
		}
		System.out.println();
	}

//В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
	public static void task1() {

		int arrSize = 10;
		int[] arr = new int[arrSize];

		randInitArr(arr);

		int k;
		do {
			k = inputInt("enter k>>");
		} while (k < 0);

		showArr(arr);

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % k == 0) {
				sum += arr[i];
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		System.out.println("sum = " + sum);

	}

//Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
//числом. Подсчитать количество замен
	public static void task2() {

		double[] arr = new double[10];
		randInitArr(arr);

		showArr(arr);

		double Z;
		Z = inputDouble("enter Z>>");

		int counter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > Z) {

				arr[i] = Z;
				counter++;
			}
		}

		showArr(arr);
		System.out.println("num of swap = " + counter);
	}

//. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
//положительных и нулевых элементов
	public static void task3() {

		int N = 10;

		double[] arr = new double[N];
		randInitArr(arr);

		showArr(arr);

		int countZero = 0;
		int countPosit = 0;
		int countNegat = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZero++;
			} else {
				if (arr[i] > 0) {
					countPosit++;
				} else {
					countNegat++;
				}
			}
		}
		
		System.out.println("num of zero = " + countZero);
		System.out.println("num of positive = " + countPosit);
		System.out.println("num of negative = " + countNegat);
	}

	public static void task4() {

		int N = 10;

		double[] arr = new double[N];
		randInitArr(arr);

		showArr(arr);

		int minIndex = 0;
		int maxIndex= 0;

		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>arr[maxIndex])
			{
				maxIndex=i;
			}else {
				if(arr[i]<arr[minIndex])
				{
					minIndex=i;
				}
			}
		}
		
		if(!(minIndex==0&&maxIndex==0))
		{
			double temp=arr[minIndex];
			arr[minIndex]=arr[maxIndex];
			arr[maxIndex]=temp;
		}
		
		showArr(arr);
	}

//Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i
	public static void task5() {
		
		final int SIZE=100;
		int[] arr = new int [SIZE];
		
		randInitArr(arr);
		showArr(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>i)
			{
				System.out.print(arr[i]+" ");
			}
			
		}
		
		System.out.println();
	}
	
	//Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
	//являются простыми числами.

	private static boolean numIsSimple(int num) {
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
			{
				return false;
			}
		}
		return true;
	}
	public static void task6() {
	
		int N;
		do {
		N=inputInt("enter N>>");
		}while(N<=0);
		
		double[]arr=new double[N];
		randInitArr(arr);
		
		showArr(arr);
		
		double sum=0;
		for(int i=0;i<arr.length;i++) {
			if(numIsSimple(i))
			{
				System.out.printf("%.2f ",arr[i]);
				sum+=arr[i];
			}
		}
		System.out.println();
		System.out.println("sum = " +sum);
	}
	
	
	//Даны действительные числа а1 ,а2 ,..., а2n Найти max(a1 + a2n, a2 + a2n−1,...,  an + an+1)
	public static void task7() {
		
		final int SIZE=5;
		double[] arr = new double [SIZE*2];
		
		randInitArr(arr);
		showArr(arr);
		
		if(arr.length<=0)
		{
			return;
		}
		
		double max=arr[0]+arr[arr.length-1];
		
		for(int i=1;i<SIZE;i++) {
			
			double currSum;
			currSum=arr[i]+arr[arr.length-i-1];
			
			if(currSum>max)
			{
				max=currSum;
			}
			
		}
		System.out.printf("max Sum = %.2f\n",max);
		
		
		
	}
	
//Дана последовательность целых чисел а1 ,а2 ,..., аn
//Образовать новую последовательность, выбросив из
//исходной те члены, которые равны min(a1 ,a2 ,... ,an ) 
	public static void task8() {
	
		final int SIZE=10;
		int[] arr = new int [SIZE];
		
		randInitArr(arr);
		showArr(arr);
		
		
		if(arr.length<=0)
		{
			return;
		}
		
		int counter =1;
		int min=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
				counter=1;
			}else
			{
				if(arr[i]==min)
				{
					counter++;
				}
			}
		}
		
		int[] newArr=new int[SIZE-counter];
		int indexOfNewArr=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=min)
			{
				newArr[indexOfNewArr++]=arr[i];
			}
		}
		
		showArr(newArr);
		
	}

//В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
//чисел несколько, то определить наименьшее из них.
	private static void inList(NumList[] arr,int num) {
		if (arr.length==0)
		{
			return;
		}
		
		int i=0;
		
		while(arr[i]!=null) {
			if(arr[i].number==num) {
				arr[i].counter++;
				return;
			}
			i++;
		}
		
		arr[i]=new NumList(num);
		
	}
	
	public static void task9() {
		int N;
		do {
		N=inputInt("enter N>>");
		}while(N<=0);
		
		
		//int[]arr= {5,5,2,7,8,10,1,1};
		int[]arr=new int[N];
		randInitArr(arr);
		
		showArr(arr);
		
		NumList[] arr2= new NumList[N];
		
		for(int i=0;i<arr.length;i++) {
			inList(arr2,arr[i]);
		}
		
		int i=1;
		int maxIndex=0;
		
		while(i<arr2.length&&arr2[i]!=null) {
			if(arr2[i].counter>arr2[maxIndex].counter)
			{
				maxIndex=i;
			}else {
				if(arr2[i].counter==arr2[maxIndex].counter)
				{
					if(arr2[i].number<arr2[maxIndex].number) {
						maxIndex=i;
					}
				}
			}
			i++;
		}
		System.out.println(arr2[maxIndex].number+" - "+arr2[maxIndex].counter);
		
	}
	
	
//Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
//элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
	public static void task10() {
		
		int N;
		do {
		N=inputInt("enter N>>");
		}while(N<=0);
		
		int[]arr=new int[N];
		randInitArr(arr);
		
		showArr(arr);
		
		int counterOfDelete=0;
		int factIndex=0;
		
		for(int i=0;i<arr.length;i++) {
			if(i%2==0)
			{
				arr[factIndex++]=arr[i];
			}else
			{
				counterOfDelete++;
			}
			
		}
		
		for(int i=arr.length-counterOfDelete;i<arr.length;i++) {
			arr[i]=0;
		}
		showArr(arr);
	}
	public static void main(String[] args) {
		task10();
		

	}

}
