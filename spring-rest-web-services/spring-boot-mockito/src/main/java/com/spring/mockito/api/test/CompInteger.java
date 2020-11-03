package com.spring.mockito.api.test;

import java.util.Comparator;

public class CompInteger implements Comparator<Student> {

	public int compareString(String s1, String s2) {

		int i1 = s1.length();//abcd
		int i2 = s2.length();//abcde

		if (i1 != i2) {
			return i1 - i2;
		} else {
			return 0;
		}

	}

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
