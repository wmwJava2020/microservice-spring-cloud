package com.spring.mockito.api.test;

public class TestComp {

	public static void main(String[] args) {
		int x = 10;		
		String  y =" AIDA";
		
		//primitive to Object		
		Integer i = Integer.valueOf(x);		
		System.out.println(i);
		
		//object to primitive
		int intVal = i.intValue();		
		System.out.println(intVal);
		
		//primitive to String
		String str = Integer.toString(x);
		System.out.println(str);
		
		//string to primitive
		int p = Integer.parseInt(str);
		System.out.println(p); 
		
		int it = Integer.parseInt(str);
		System.out.println(it);
		
		
		
	}

}
