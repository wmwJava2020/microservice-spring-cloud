package com.usa.employee.utility.test;

public class PowerNumber2 {

	static int power(int N, int P) {
		if (P == 0)
			return 1;
		else
			return N * power(N, P - 1);

	}

	public static void main(String[] args) {
		int N = 4;
		int P = 4;

		System.out.println(power(N, P));

	}

}
