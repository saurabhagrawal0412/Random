package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class ByteArray_Test {

	public static void main(String[] args) {
		ByteArray_Test obj = new ByteArray_Test() ;
		
		try {
			byte[] bArray = obj.writeData() ;
			obj.readData(bArray) ;
		}
		catch(IOException e) {
			System.err.println("IOException") ;
			e.printStackTrace() ;
		}
	}

	private byte[] writeData() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream() ;
		
		Random rand = new Random() ;
		for(int i=0 ; i<20 ; i++) {
			out.write(rand.nextInt(20)) ;
		}
		
		byte[] bArray = out.toByteArray() ;
		
		out.close() ;
		return bArray ;
	}
	
	private void readData(byte[] bArray) throws IOException {
		ByteArrayInputStream in = new ByteArrayInputStream(bArray) ;
		
		int data = in.read() ;
		while(data != -1) {
			System.out.print(data + " ") ;
			data = in.read() ;
		}
		System.out.println() ;
		in.close() ;
	}
}
