package networking;

import java.net.*;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception {

		URL myURL = new URL("http://jenkov.com/");
		BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		
		URLConnection myURLConnection = myURL.openConnection();
		myURLConnection.setDoOutput(true) ;
	    myURLConnection.connect();
	    System.out.println("Connection established: ") ;
	    System.out.println(myURLConnection.toString()) ;
	    
	    OutputStream os = myURLConnection.getOutputStream() ;
	    os.write("Hello Jenkov".getBytes()) ;
			
		in.close();
	}
}