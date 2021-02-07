package com.website.objects_and_classes.task2;

public class Test2 {
		
		private int a;
		private int b;
		
		public Test2() {
			
			a=0;
			b=0;
			
		}
		
		public Test2(int a, int b) {
			
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
		
		public boolean equalTo(Test2 obj) {
			
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			
			if (this.getClass() != obj.getClass())
				return false;
			
			if(a==obj.a&&b==obj.b) {
				return true;
			}
			
			return false;
				
		}
		
		public int hashCode() {
			
			final int prime = 31;
			int result=1;
			
			result=prime*result+a;
			result = prime*result+b;
			
			return result;
		}
		
	
		public String toString() {
			
			return "Test2{ "+
					" a = " + a +
					", b = " + b +
							" }";
		}
}
