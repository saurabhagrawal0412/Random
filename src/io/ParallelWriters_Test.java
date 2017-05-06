package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ParallelWriters_Test {
	public static void main(String[] args) {
		for(int i=0 ; i<5 ; i++) {
			MyWriter myWriter = new MyWriter() ;
			Thread thread = new Thread(myWriter) ;
			thread.start() ;
		}
	}
}

class MyWriter implements Runnable {
	private static int counter = 1 ;
	@Override
	public void run() {
		System.out.println("Counter = " + counter++) ;
		try {
			Writer writer = new FileWriter("E:\\Java\\TempWS\\MyProject\\src\\io\\writer.txt") ;
			writer.write("ABCDEFGHI") ;
			//Thread.sleep(500) ;
			writer.close() ;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}