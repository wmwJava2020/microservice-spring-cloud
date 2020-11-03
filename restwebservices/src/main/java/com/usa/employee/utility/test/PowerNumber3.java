package com.usa.employee.utility.test;

public class PowerNumber3 {

	static double power(int N, int P) {

		return Math.pow(N, P);
	}

	public static void main(String[] args) {
		int P = 3;
		int N = 3;

		System.out.println(power(N, P));
	}

}
