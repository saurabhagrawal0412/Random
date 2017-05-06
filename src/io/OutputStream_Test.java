package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream_Test {

	public static void main(String[] args) {
		OutputStream_Test obj = new OutputStream_Test() ;
		obj.writeDataToFile() ;
		obj.readDataFromFile() ;
	}
	
	private void writeDataToFile() {		
		
		try( FileOutputStream fos = new FileOutputStream("E:\\Java\\TempWS\\MyProject\\src\\io\\data.dat");
			DataOutputStream dos = new DataOutputStream(fos) ) {
			int[] intArray = { 1, 2, 3, 4, 5 } ;
			for(int temp : intArray) {
				dos.writeInt(temp) ;
			}
			
			boolean[] boolArray = { true, false, true, false, true, false } ;
			for(boolean temp : boolArray) {
				dos.writeBoolean(temp) ;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readDataFromFile() {		
		
		try( FileInputStream fis = new FileInputStream("E:\\Java\\TempWS\\MyProject\\src\\io\\data.dat");
			DataInputStream dis = new DataInputStream(fis) ) {
			int[] intArray = new int[5] ;
			for(int i=0 ; i<intArray.length ; i++) {
				intArray[i] = dis.readInt() ;
				System.out.println(intArray[i]) ;
			}
			
			boolean[] boolArray = new boolean[5] ;
			for(int i=0 ; i<boolArray.length ; i++) {
				boolArray[i] = dis.readBoolean() ;
				System.out.println(boolArray[i]) ;
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

