package com.usa.employee.utility.test;

public class CalculatePowerNumber {
	
	
	public int power(int N, int P) {
		
		if(P==0)
			return 1;
		else 
			return N * power(N, P-1);
		
	}

	public static void main(String[] args) {
		CalculatePowerNumber n = new CalculatePowerNumber();
		
		int N = 3;
		int P = 2;
		 
	System.out.println(n.power(N, P)); 
		


	}

}
