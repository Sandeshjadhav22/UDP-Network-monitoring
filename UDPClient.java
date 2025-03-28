import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        int clientPort = 54321; // Choose any suggested port
        try (DatagramSocket socket = new DatagramSocket(clientPort)) {
            String message = "Hello from Client, i am sandesh sanjay jadhav!";
            byte[] buffer = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 9999);
            socket.send(packet);
            System.out.println("UDP packet sent from port " + clientPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
