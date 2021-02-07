package com.website.objects_and_classes.task1;

public class Main {
	
	public static void main(String[] args) {
		
		Test1 ob= new Test1();

		ob.setA(5);
		ob.setB(10);
		
		System.out.println("biggest is "+ob.biggestNumber());
		System.out.println("sum is "+ob.sum());
		
		System.out.println(ob.toString());
		
	}
	

}
