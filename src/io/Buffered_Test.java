package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Buffered_Test {

	public static void main(String[] args) {
		try(InputStream in = new BufferedInputStream(new FileInputStream("E:/Java/TempWS/MyProject/src/io/random.txt"), 8192)) {
			for(int i=0 ; i<20 ; i++) {
				System.out.print((char)in.read()) ;
			}
			System.out.println() ;
			in.mark(8192) ;
			
			for(int i=0 ; i<20 ; i++) {
				System.out.print((char)in.read()) ;
			}
			System.out.println();
			in.reset() ;
			
			for(int i=0 ; i<20 ; i++) {
				System.out.print((char)in.read()) ;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
