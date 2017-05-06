package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Datagram_Test {

	public static void main(String[] args) {
		DatagramServer server = new DatagramServer() ;
		new Thread(server).start() ;
		
		DatagramClient client = new DatagramClient() ;
		new Thread(client).start() ;
	}
}

class DatagramClient implements Runnable {

	@Override
	public void run() {
		try (DatagramSocket socket = new DatagramSocket() ;)
		{
			String str = "Hello from Client" ;
			byte[] buffer = str.getBytes() ;
			InetAddress address = InetAddress.getByName("127.0.0.1") ;
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4446) ;
			socket.send(packet) ;
			
			buffer = new byte[256] ;
			packet = new DatagramPacket(buffer, buffer.length) ;
			socket.receive(packet) ;
			str = new String(packet.getData(), 0, packet.getLength()) ;
			System.out.println("String received by client: " + str) ;
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class DatagramServer implements Runnable {

	@Override
	public void run() {
		try (DatagramSocket socket = new DatagramSocket(4446) ;)
		{
			byte[] buffer = new byte[256] ;
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length) ;
			socket.receive(packet) ;
			String str = new String(packet.getData(), 0, packet.getLength()) ;
			System.out.println("String received by server: " + str) ;
			
			str = "Hello from server" ;
			buffer = str.getBytes() ;
			InetAddress address = packet.getAddress() ;
			int port = packet.getPort() ;
			
			packet = new DatagramPacket(buffer, buffer.length, address, port) ;
			socket.send(packet) ;
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}