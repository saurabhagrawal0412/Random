package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class File_Test {

	public static void main(String[] args) {
		File_Test obj = new File_Test() ;
		obj.createDirectory() ;
		
		try {
			obj.createFile() ;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		obj.readFilesInDirectory() ;
	}

	private void createDirectory() {
		String path = "E:/Java/TempWS/MyProject/src/io/files" ;
		
		File file = new File(path) ;
		
		if(! file.exists()) {
			boolean isCreated = file.mkdir() ;
			
			if(isCreated) {
				System.out.println("Directory created") ;
			}
		}
		else {
			System.out.println("Directory already exists") ;
		}
	}
	
	private void createFile() throws IOException {
		String path = "E:/Java/TempWS/MyProject/src/io/files/file1.txt" ;
		
		File file = new File(path) ;
		
		if(file.exists()) {
			System.out.println("File exists") ;
			System.out.println("file.length = " + file.length()) ;
			System.out.println("file.getParent = " + file.getParent()) ;
			
			System.out.println("file.lastModified = " + file.lastModified()) ;
			file.setLastModified(10000) ;
			System.out.println("file.lastModified = " + file.lastModified()) ;
			
			System.out.println("file.canWrite = " + file.canWrite()) ;
			System.out.println("file.getPath = " + file.getPath()) ;
			
			System.out.println("file.getName = " + file.getName()) ;
			String modifiedPath = "E:/Java/TempWS/MyProject/src/io/files/file2.txt" ;
			file.renameTo(new File(modifiedPath)) ;
			System.out.println("file.getName = " + file.getName()) ;
			
			System.out.println("file.getCanonicalPath = " + file.getCanonicalPath()) ;
		}
		else {
			System.out.println("File does not exist") ;
			writeFile(file) ;
		}
	}

	private void writeFile(File file) {
		try(Writer writer = new FileWriter(file)) {
			writer.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ") ;
			writer.flush() ;
			System.out.println("Write completed") ;
		}
		catch (IOException e) {
			System.err.println("Something happened") ;
			e.printStackTrace();
		}
	}
	
	private void readFilesInDirectory() {
		String path = "E:/Java/TempWS/MyProject/src/io" ;
		File file = new File(path) ;
		File[] files = file.listFiles() ;
		
		System.out.println("Reading the list of files") ;
		for(File tFile : files) {
			System.out.println(tFile.getName()) ;
		}
	}
}
