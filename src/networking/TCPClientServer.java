package networking;

import java.net.*;
import java.io.*;

public class TCPClientServer {

	public static void main(String[] args) {
		DateServer server = new DateServer() ;
		DateClient client = new DateClient() ;
		
		Thread t1 = new Thread(server) ;
		t1.start() ;
		
		t1 = new Thread(client) ;
		t1.start() ;
	}
}

class DateServer implements Runnable {
	@Override
	public void run() {
		try(ServerSocket socket = new ServerSocket(6013)) {
			long milliseconds1 = System.currentTimeMillis() ;

			/* now listen for connections */
			while (System.currentTimeMillis() - milliseconds1 <= 40) {
				Socket client = socket.accept();
				System.out.println("Server printing first socket: " + client.getPort()) ;
				System.out.println("Server printing second socket: " + client.getLocalPort()) ;
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				/* write the Date to the socket */
				pout.println(new java.util.Date().toString());
				/* close the socket and resume */
				/* listening for connections */
				client.close();
			}
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}

class DateClient implements Runnable {
	public void run() {
		try {
			/* make connection to server socket */
			Socket socket = new Socket("127.0.0.1", 6013);
			System.err.println("Client printing first port: " + socket.getPort()) ;
			System.err.println("Client printing second port: " + socket.getLocalPort()) ;
			InputStream in = socket.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			/* read the date from the socket */
			String line;
			while ((line = bin.readLine()) != null)
				System.out.println(line);
			
			/* close the socket connection */
			socket.close();
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}