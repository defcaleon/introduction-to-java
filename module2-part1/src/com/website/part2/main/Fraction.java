package com.website.part2.main;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	Fraction(int x, int y){
		
		numerator = x;
		
		if(y==0) {
			denominator=1;
		}
		else {
			denominator = y;
		}
		
		
	}
	
	public void setNumerator(int num) {
		numerator = num;
		
	}
	public void setDenominator(int num) {
		if(num!=0) {
			denominator = num;
		}
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void show() {
		
		System.out.println(numerator+"/"+denominator);
	}

}
