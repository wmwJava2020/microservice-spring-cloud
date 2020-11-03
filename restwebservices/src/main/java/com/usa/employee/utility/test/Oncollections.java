package com.usa.employee.utility.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oncollections {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");

		List<String> l = Collections.synchronizedList(list);
		System.out.println(l);

	}

}
