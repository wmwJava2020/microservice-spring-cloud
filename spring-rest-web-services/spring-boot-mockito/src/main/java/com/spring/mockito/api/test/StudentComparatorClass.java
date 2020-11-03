package com.spring.mockito.api.test;

import java.util.Comparator;

public class StudentComparatorClass implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		return o1.getId() - o2.getId();
	}

	public int compare(int a, int b) {

		if (a == b)
			return 1;
		return -1;

	}

	public int compareString(String s1, String s2) {

		int i1 = s1.length();
		int i2 = s2.length();

		if (i1 != i2) {
			return i1 - i2;
		} else {

			return 0;
		}

	}

	public boolean compareArrays(String[] arr1, String[] arr2) {

		String[] x = { "A", "G", "P","T", "G", "Q"};
		String[] y = {"F",  "L","U", "Z" };

		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y.length; j++) {
				if (x[i].equals(y[j])) {
					System.out.println(x[i] + " " + y[j]);
				}
			}
		}
		return false;
	}

}
