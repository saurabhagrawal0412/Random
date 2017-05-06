package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientServer {

	public static void main(String[] args) {
		UDPServer server = new UDPServer() ;
		UDPClient client = new UDPClient() ;
		
		Thread t = new Thread(server) ;
		t.start() ;
		
		t = new Thread(client) ;
		t.start() ;
	}

}

class UDPServer implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Server started") ;
		try {
			DatagramSocket serverSocket = new DatagramSocket(9876);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String sentence = new String(receivePacket.getData());
				System.out.println("RECEIVED: " + sentence);
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				String capitalizedSentence = sentence.toUpperCase();
				sendData = capitalizedSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
			}
		}
		catch(IOException e) {
			System.err.println("IO Exception") ;
			e.printStackTrace() ;
		}
	}
}

class UDPClient implements Runnable {

	@Override
	public void run() {
		System.out.println("Client started") ;
		try {
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			String modifiedSentence = new String(receivePacket.getData());
			System.out.println("FROM SERVER:" + modifiedSentence);
			clientSocket.close();
		}
		catch(IOException e) {
			System.err.println("IOException") ;
			e.printStackTrace() ;
		}
	}
	
}