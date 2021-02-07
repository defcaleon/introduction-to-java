package com.website.part3.main;

import java.util.Random;

import com.website.part2.main.Part2;
import com.website.part1.main.Main;

public class Part3 {
	

	
//task1
//. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
//натуральных чисел: 
// данные методы описаны в com.website.part2.main.Part2
	
	
//Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел
	private static int NOD4Num(int a, int b, int c, int d) {
		
		int temp =Part2.NOD(a, b);
		temp = Part2.NOD(c, temp);
		return  Part2.NOD(temp, d);
		
		
	}
	
	public static void task2() {
		
		System.out.printf("NOD %d",NOD4Num(0,30,5,20));
		
	}
//Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
//треугольника.
	private static double regularTriangleArea(int a) {
		return Math.sqrt(3)/4*a*a;
	}
	
	public static void task3() {
		
		int a=4;
		
		double area = 6*regularTriangleArea(a);
		
		System.out.printf("area = %.2f \n", area);
	}
	
//На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
//из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
	private static double distBetween2Dot(Dot first, Dot second) {
		
		int x=(int) Math.pow((second.getX()-first.getX()), 2);
		int y=(int) Math.pow((second.getY()-first.getY()), 2);
		
		return Math.sqrt(x+y);
	}
	
	private static void showDotsArr(Dot[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.print((i+1)+") ");
			arr[i].show();
		}
		
		System.out.println();
		
		
	}
	public static void task4() {
		
		int n=10;
		
		Dot[] arr= new Dot[n];
		
		Random rand = new Random();
		for(int i=0;i<arr.length;i++) {
			
			arr[i]= new Dot(rand.nextInt(200)-100,rand.nextInt(200)-100);
			
		}
		
		showDotsArr(arr);
		
		double maxDistance=0;
		
		int firstIndex=-1;
		int secondIndex=-1;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				double currDist = distBetween2Dot(arr[i],arr[j]);
				if(currDist>maxDistance) {
					
					maxDistance=currDist;
					firstIndex=i;
					secondIndex=j;
					
				}
			}
		}
		
		firstIndex++;
		secondIndex++;
		System.out.printf("max dist is %.2f between %d %d\n ",maxDistance,firstIndex,secondIndex);
		
	}
	
// Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
// которое меньше максимального элемента массива, но больше всех других элементов).
	private static int secondMaxInArr(int[]arr, int max) {
		if(arr.length==0) {
			return -1;
		}else
		{
			int secondMax=-1;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>secondMax&&arr[i]<max) {
					secondMax=arr[i];
				}
			}
			
			return secondMax;
		}
		
	}
	
	private static int maxNumInArr(int[] arr) {
		if(arr.length==0) {
			return -1;
		}else
		{
			int max=arr[0];
			
			for(int i=1;i<arr.length;i++) {
				if(max<arr[i]) {
					max=arr[i];
				}
				
			}
			return max;
		}
	}
	public static void task5() {
		
		int N=10;
		
		int[] arr = new int[N];
		
		Main.randInitArr(arr);
		Main.showArr(arr);
		
		int max=maxNumInArr(arr);
		int secondMax=secondMaxInArr(arr,max);
		
		System.out.println("sec max is "+secondMax);
		
		
		
	}
	
//Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми
	private static boolean primeNumbers(int a, int b,int c) {
		if(Part2.NOD(a, b)!=1) {
			return false;
		}else
		{
			if(Part2.NOD(a,c)!=1) {
				return false;
			}else
			{
				if(Part2.NOD(b, c)!=1) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static void task6() {
		
		int num1=5;
		int num2=7;
		int num3=8;
		
		if(primeNumbers(num1,num2,num3)) {
			System.out.println("these numbers are mutually prime ");
		}
		else
		{
			System.out.println("these numbers aren't mutually prime ");
		}
		
	}
//Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9
	private static int factorial(int n) {
		
		int sum=1;
		for(int i=1;i<=n;i++) {
			sum*=i;
		}
		
		return sum;
		
	}
	public static void task7() {
		
		int sum=0;
		
		for(int i=1;i<=9;i+=2) {
			sum+=factorial(i);
		}
		System.out.println("Sum = "+sum);
	}
	
//Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
//массива с номерами от k до m.
	private static int sumTrio(int k, int m, int[] arr) {
		if (0>k&&arr.length<=m) {
			return -1;
		}
		
		int sum=0;
		for(int i=k;i<=m;i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static void  task8() {
		
		int SIZE=10;
		
		int[]D = new int[SIZE];
		Main.randInitArr(D);
		Main.showArr(D);
		
		int sum;
		for(int i=0,start=0;i<SIZE/3;i++) {
			
			sum=sumTrio(start,start+2,D);
			System.out.printf("Sum %d %d %d = %d\n",D[start++],D[start++],D[start++],sum);
		}
		
	}

//Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
//если угол между сторонами длиной X и Y— прямой.
	private static double quadArea(int x, int y, int z , int t) {
		
		double diagonal = Math.sqrt(x*x+y*y);
		
		double halfArea= x*y/2;
		
		double halfPerimetr= (z+t+diagonal)/2;
		
		double halfAreaGeron=Math.sqrt(halfPerimetr*(halfPerimetr-z)*(halfPerimetr-t)*(halfPerimetr-diagonal));
		
		return halfArea+halfAreaGeron;
	}
	
	public static void  task9() {
		
		int a=3;
		int b=4;
		int c=5;
		int d=5;
		
		System.out.printf("Area  = %.2f\n",quadArea(a,b,c,d));
		
		
	}
	
//Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
//являются цифры числа N.
	private static int numOfNumber(int num) {
		
		int counter=0;
		while(num>0) {
			num/=10;
			counter++;
		}
		
		return counter;
	}
	private static int[] numArrFromNumber(int num) {
		
		int numOfnum=numOfNumber(num);
		
		int[] arr = new int[numOfnum];
		
		for(int i=0,temp;i<arr.length;i++) {
			
			temp=num%10;
			num/=10;
			arr[i]=temp;
		}
		
		return arr;
		
	}
	public static void  task10() {
		
		int num=12345;
		
		int[] arr= numArrFromNumber(num);
		
		System.out.printf("num  = %d\n",num);
		Main.showArr(arr);
		
	}
	
// Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр

	//1  если в первом больше цифр чем во втором
	// 0 если во втором больше цифр чем в первом
	//-1 если одинаково цифр
	private static int compNumber(int a, int b) {
		
		 int countA=numOfNumber(a);
		 int countB=numOfNumber(b);
		 
		 return (countA>countB?1:countA==countB?-1:0);
	}
	public static void  task11() {
		
		int a=123123;
		int b=323;
		
		int win=compNumber(a,b);
		if(win==-1) {
			System.out.println(a+"="+b);
		}else
		{
			if(win==1) {
				System.out.println(a+">"+b);
			}else
				System.out.println(a+"<"+b);
		}
	}
	
//. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
//являются числа, сумма цифр которых равна К и которые не большее N.
	private static int formNumberFromK(int k, int n) {
		
		if(k==0||n==0){
			return 0;
		}
		Random rand = new Random();
		
		int newNum=0;
		int iteration=0;
		
		while(k>0&&iteration<10000) {
			
			int nextNum=rand.nextInt(10);
			
			if(k-nextNum>=0) {
				
				if(newNum*100+nextNum*10<n) {
					newNum=newNum*10+nextNum;
					k-=nextNum;
					
				}else
				{
					if(newNum*10+nextNum<=n&&k==nextNum) {
					
						newNum=newNum*10+nextNum;
						k-=nextNum;
					
						}
				}
				
				
			}
			
			iteration++;
		}
			
		
		return newNum;
	}
	private static int[] makeArr(int k, int n, int size) {
		
		int[] arr = new int[size];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=formNumberFromK(k,n);
		}
		
		return arr;
	}
	
	public static void task12() {
		
		int k=12;
		int n=20000;
		final int SIZE=10;
		int []A= makeArr(k,n,SIZE);
		
		Main.showArr(A);
		
	}
	
//Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
//Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
//решения задачи использовать декомпозицию.
	
	public static void task13() {
		int n=40;
		
		if(n>2) {
			
			for(int i=n;i<2*n-1;i++) {
				System.out.println(i+" - "+(i+2));
			}
			
		}
	
	}
	
	
//Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
//возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
//использовать декомпозицию.
	private static int sumOfNumInNumPow(int num) {
		
		int pow=numOfNumber(num);
		int sum=0;
		while(num>0) 
		{
			sum+=Math.pow(num%10, pow);
			num/=10;
		}
		
		return sum;
	}
	public static void task14() {
		
		int k=1000;
		
		System.out.println("list of numbers");
		for(int i=1;i<=k;i++) {
			
			int sum=sumOfNumInNumPow(i);
			
			if( sum==i) {
				System.out.println(i);
			}
		}
		
	}
	
//Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
//последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
	private static boolean checkNumForNumOrder(int num) {
		
		if(num==0)
		{
			return true;
		}
		
		
		int maxNum=num%10;
		num/=10;
			
		while(num>0) {
			
			int currNum=num%10;
			num/=10;
			
			if(currNum>=maxNum) {
				return false;
			}
			
			maxNum=currNum;
		}
	
			
		return true;	
	}
	
	public static void task15() {
		int n=4;
		for(int  i=(int) Math.pow(10, n-1);i<Math.pow(10, n);i++)
		{
			if(checkNumForNumOrder(i)) {
				System.out.print(i+" ");
			}
			
		}
		
	}
	
//Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
//Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
	private static boolean oddNumCheck(int num) {
		
		while(num>0) {
			
			if((num%10)%2==1) {
				return false;
			}
			
			num/=10;
		}
		
		return true;
	}
	
	private static int numOfEvenNumInNumber(int num) {
		
		int counter=0;
		
		while(num>0) {
			
			if((num%10)%2==0) {
				counter++;
			}
			
			num/=10;
			
		}
		
		return counter;
	}
	
	public static void task16() {
	
		int n=3;
		int sum=0;
		
		for(int  i=(int) Math.pow(10, n-1);i<Math.pow(10, n);i++)
		{
			if(oddNumCheck(i)) {
				sum+=i;
			}
			
		}
		
		System.out.print("sum = "+sum+" num of even numbers is "+numOfEvenNumInNumber(sum));
	}
	
// Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
// действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
	
	private static int sumOfNumInNum(int num) {
		
		int sum=0;
		while(num>0) 
		{
			sum+=num%10;
			num/=10;
		}
		
		return sum;
	}
	
	public static void task17() {
	
		int num=100;
		
		int counter=0;
		int sumInNum=sumOfNumInNum(num);
		
		while(num>0) {
			num-=sumInNum;
			counter++;
		}
		
		if(num==0) {
			System.out.println("answer = "+counter+" times");
		}else
		{
			System.out.println("Impossible to get 0");
		}
		
	}
	
	public static void main(String[] args) {
		

		task17();
		
	}
	

}
