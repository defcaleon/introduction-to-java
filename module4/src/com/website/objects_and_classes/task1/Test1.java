package com.website.objects_and_classes.task1;

public class Test1 {
	
	private int a;
	private int b;
	
	public Test1() {
		
		a=0;
		b=0;
		
	}
	
	public Test1(int a, int b) {
		
		this.a=a;
		this.b=b;
		
	}
	
	public void setA(int a) {
		
		this.a=a;
	}
	
	public void setB(int b) {
		this.b=b;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int sum() {
		return a+b;
	}
	
	public int biggestNumber() {
		return a>b?a:b;
	}
	
	public String toString() {
		
		return "Test1{ "+
				" a = " + a +
				", b = " + b +
						" }";
	}

}
