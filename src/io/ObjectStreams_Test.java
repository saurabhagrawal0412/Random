package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreams_Test {

	public static void main(String[] args) {
		ObjectStreams_Test obj = new ObjectStreams_Test() ;
		Person[] people = new Person[2] ;
		people[0] = new Person(21, "Saurabh") ;
		people[1] = new Person(24, "Agrawal") ;
		
		try {
			obj.writeData(people) ;
			obj.readAndPrintData() ;
		}
		catch(ClassNotFoundException e) {
			System.err.println("Class not found") ;
			e.printStackTrace() ;
		}
		catch(FileNotFoundException e) {
			System.err.println("File not found") ;
			e.printStackTrace() ;
		}
		catch(IOException e) {
			System.err.println("IO Exception") ;
			e.printStackTrace() ;
		}
	}

	private void writeData(Person[] people) throws FileNotFoundException, IOException {
		try(FileOutputStream fos = new FileOutputStream("E:/Java/TempWS/MyProject/src/io/object.dat") ;
				ObjectOutputStream oos = new ObjectOutputStream(fos) ) {
			oos.writeObject(people) ;
			oos.flush() ;
		}
	}
	
	private void readAndPrintData() throws FileNotFoundException, IOException, ClassNotFoundException {
		try(FileInputStream fis = new FileInputStream("E:/Java/TempWS/MyProject/src/io/object.dat") ;
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			Person[] people = (Person[]) ois.readObject() ;
			
			for(int i=0 ; i<people.length ; i++) {
				System.out.println(people[i].toString()) ;
			}
		}
	}
}

class Person implements Serializable {
	private static final long serialVersionUID = 1L ;
	private int age ;
	private String name ;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("Age = " + age) ;
		sb.append("\nName = " + name) ;
		return sb.toString() ;
	}
}