package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoClientServer {

	public static void main(String[] args) {
		EchoServer server = new EchoServer() ;
		new Thread(server).start() ;
		
		EchoClient client = new EchoClient() ;
		new Thread(client).start() ;
	}
}

class EchoServer implements Runnable {
	@Override
	public void run() {
		try(ServerSocket servSock = new ServerSocket(9999) ;
			Socket clientSock = servSock.accept() ;
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSock.getInputStream() ) ) ;
			PrintWriter writer = new PrintWriter(clientSock.getOutputStream(), true) )
		{
			writer.println("Hello from server") ;
			writer.flush() ;
			System.out.println(reader.readLine()) ;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class EchoClient implements Runnable {
	@Override
	public void run() {
		try(Socket sock = new Socket("127.0.0.1", 9999) ;
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream() ) ) ;
			PrintWriter writer = new PrintWriter(sock.getOutputStream(), true) )
		{
			writer.println("Hello from Client") ;
			writer.flush() ;
			System.out.println(reader.readLine()) ;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}