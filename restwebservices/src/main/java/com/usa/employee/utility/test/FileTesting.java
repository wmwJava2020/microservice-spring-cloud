package com.usa.employee.utility.test;

import java.io.File;
import java.util.concurrent.atomic.LongAdder;

public class FileTesting {

	public static void main(String[] args) {
		
		File myDir = new File("C:\\Users\\wonda\\Desktop\\doc"); 
				final LongAdder dirCount = new LongAdder();
				final LongAdder filCount = new LongAdder();
				if (myDir.isDirectory()) {
				 myDir.listFiles( (File f) -> {
				 if (f.isDirectory()) {
				 dirCount.increment();
				 return false;
				 }
				 if (f.isFile()) {
				 filCount.increment();
				 return false;
				 }
				 return false;
				 }
				 );
				} 

	}

}
