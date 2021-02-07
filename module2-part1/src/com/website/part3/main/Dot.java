package com.website.part3.main;

public class Dot {
	
	private int x;
	private int y;
	
	Dot(int x,int y ){
		
		this.x=x;
		this.y=y;
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void show() {
		System.out.printf("x=%+3d y=%+3d\n",x,y);
	}
	
	

}
