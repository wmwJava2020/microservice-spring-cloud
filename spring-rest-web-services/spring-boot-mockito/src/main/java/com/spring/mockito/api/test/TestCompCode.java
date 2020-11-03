package com.spring.mockito.api.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCompCode {

	public static void main(String[] args) {
		List<Student> st = new ArrayList<Student>();
		
		Student s0 = new Student(92,"G");
		Student s1 = new Student(23,"D");
		Student s2 = new Student(82,"R");
		Student s3 = new Student(72,"O");
		Student s4 = new Student(62,"B");
		Student s5 = new Student(12,"K");
		
		st.add(s0);
		st.add(s1);
		st.add(s2);
		st.add(s3);
		st.add(s4);
		st.add(s5);
		
		Collections.sort(st, new StudentComparatorClass());
		for(Student stu : st) {
			//System.out.println(stu);
		}
		
		CompInteger str = new CompInteger();
			String s10 = new String("abcde");
			String s20 = new String("abcde");
			String s30 = new String("efghi");
			String s40 = new String("EFGH");

		//System.out.println(str.compareString(s30, s40));
		
		
		String[] x = {"A", "G", "P","T", "G", "Q", "G"};
		String[] y = {"F", "L","U", "A", "Z" ,"Q"};

		
		StudentComparatorClass c = new StudentComparatorClass();
		//c.compareArrays(x, y);
		System.out.print( 	c.compareArrays(x, y));
		
		
	}

	
	
}
