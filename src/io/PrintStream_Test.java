package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_Test {

	public static void main(String[] args) {
		PrintStream_Test obj = new PrintStream_Test() ;
		obj.writeFile() ;
	}

	private void writeFile() {
		try (	FileOutputStream fos = new FileOutputStream("E:/Java/TempWS/MyProject/src/io/print.txt") ;
				PrintStream ps = new PrintStream(fos) ) {
			ps.println(true) ;
			ps.println(123.234) ;
			fos.flush() ;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
