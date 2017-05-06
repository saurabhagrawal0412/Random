package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.Random;

public class RandomAccessFile_Test {

	String path = "E:\\Java\\TempWS\\MyProject\\src\\io\\random.txt" ;
	
	public static void main(String[] args) {
		RandomAccessFile_Test obj = new RandomAccessFile_Test() ;
		obj.writeData() ;
		obj.writeRandomData() ;
		obj.readRandomData() ;
	}

	private void writeData() {
		try(Writer writer = new BufferedWriter(new FileWriter(path))) {
			Random rand = new Random() ;
			
			for(int i=0 ; i<200 ; i++) {
				for(int j=0 ; j<20 ; j++) {
					char ch = (char) (rand.nextInt(26) + 97 ) ;
					writer.write(ch) ;
				}
				writer.write('\n') ;
			}
			writer.flush() ;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeRandomData() {
		try(RandomAccessFile raf = new RandomAccessFile(new File(path), "rw")) {
			raf.seek(41) ;
			raf.write("\nHelloHelloHelloHello\n".getBytes()) ;
			raf.close() ;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readRandomData() {
		try(RandomAccessFile raf = new RandomAccessFile(new File(path), "r")) {
			byte[] bArray = new byte[20] ;
			raf.seek(42) ;
			raf.readFully(bArray) ;
			raf.close() ;
			
			for(byte b: bArray) {
				System.out.print((char)b) ;
			}
			System.out.println() ;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
