package io;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class ArrayInputStreamTest {

	public static void main(String[] args) throws IOException {
		byte[] byteArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 } ;
		char[] charArr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' } ;
		
		InputStream input = new ByteArrayInputStream(byteArr) ;
		
		int data = input.read() ;
		
		while(data != -1) {
			System.out.print(data) ;
			data = input.read() ;
		}
		System.out.println() ;
		Reader reader = new CharArrayReader(charArr) ;
		data = reader.read() ;
		
		while(data != -1) {
			System.out.print((char) data) ;
			data = reader.read() ;
		}
		System.out.println() ;
		System.err.println("Hello, world !!") ;
	}
}