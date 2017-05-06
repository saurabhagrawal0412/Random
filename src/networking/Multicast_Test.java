package networking ;

import java.io.IOException ;
import java.net.DatagramPacket ;
import java.net.InetAddress ;
import java.net.MulticastSocket ;

public class Multicast_Test {

	public static void main(String[] args) {
		MulticastClient[] clients = new MulticastClient[5] ;
		
		for(int i=0 ; i<clients.length ; i++) {
			clients[i] = new MulticastClient() ;
			new Thread(clients[i]).start() ;
		}
		
		MulticastServer server = new MulticastServer() ;
		new Thread(server).start() ;
	}
}

class MulticastClient implements Runnable {
	private static int counter = 0 ;
	private int id = 0 ;
	
	MulticastClient() {
		id = counter++ ;
	}
	
	@Override
	public void run() {
		try(MulticastSocket socket = new MulticastSocket(4446) ;)
		{
			InetAddress address = InetAddress.getByName("230.0.0.1") ;
			socket.joinGroup(address) ;
			
			for (int i = 0 ; i < 5 ; i++) {
				byte[] buf = new byte[256] ;
				DatagramPacket packet = new DatagramPacket(buf, buf.length) ;
				socket.receive(packet) ;

				String received = new String(packet.getData(), 0, packet.getLength()) ;
				System.out.println("Data received by process:" + id + " msg=" + received) ;
			}
			socket.leaveGroup(address) ;
		}
		catch (IOException e) {
			e.printStackTrace() ;
		}
	}
}

class MulticastServer implements Runnable {
	
	@Override
	public void run() {
		try(MulticastSocket socket = new MulticastSocket() ;)
		{
			InetAddress group = InetAddress.getByName("230.0.0.1") ;
			String[] sArr = {"one", "two", "three", "four", "five"} ;
			byte[] buffer ;
			
			for (int i = 0 ; i < sArr.length ; i++) {
				buffer = sArr[i].getBytes() ;
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446) ;
				socket.send(packet) ;
			}
		}
		catch (IOException e) {
			e.printStackTrace() ;
		}
	}
}