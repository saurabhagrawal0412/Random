package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;

public class Pushback_Example {

	public static void main(String[] args) {
		try(PushbackInputStream in = new PushbackInputStream(new FileInputStream("E:/Java/TempWS/MyProject/src/io/random.txt"), 8192)) {
			int[] arr = new int[20] ;
			for(int i=0 ; i<20 ; i++) {
				System.out.print( arr[i] = in.read() );
			}
			System.out.println() ;
			
			for(int i=arr.length-1 ; i>=0 ; i--) {
				in.unread(arr[i]) ;
			}
			
			for(int i=0 ; i<20 ; i++) {
				System.out.print( arr[i] = in.read() );
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
