package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Readers_Test {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("E:\\Java\\TempWS\\MyProject\\src\\io\\reader.txt") ;
		int data = reader.read() ;
		while(data != -1) {
			System.out.print((char)data) ;
			data = reader.read() ;
		}
		System.out.println() ;
		reader.close() ;
		
		InputStream stream = new FileInputStream("E:\\Java\\TempWS\\MyProject\\src\\io\\reader.txt") ;
		reader = new InputStreamReader(stream) ;
		data = reader.read() ;
		while(data != -1) {
			System.out.print((char)data) ;
			data = reader.read() ;
		}
		System.out.println() ;
		reader.close() ;
		
		reader = new BufferedReader(new FileReader("E:\\Java\\TempWS\\MyProject\\src\\io\\reader.txt"), 9) ;

		data = reader.read() ;
		while(data != -1) {
			System.out.print((char)data) ;
			data = reader.read() ;
		}
		System.out.println() ;
		reader.close() ;
	}

}
