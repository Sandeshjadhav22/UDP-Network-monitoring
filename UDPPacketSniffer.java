import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPPacketSniffer {
    private static final int BUFFER_SIZE = 1024;
    private static final int LISTEN_PORT = 9999;

    public static void main(String[] args){
        try(DatagramSocket socket = new DatagramSocket(LISTEN_PORT)){
            System.out.println("UDP Packet Sniffer started on port " + LISTEN_PORT);
            byte[] buffer = new byte[BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true){
                socket.receive(packet);
                logPacket(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logPacket(DatagramPacket packet){
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String sourceIP =   packet.getAddress().toString();
        int sourcePort = packet.getPort();
        int packetSize = packet.getLength();
        String data = new String(packet.getData(), 0,packetSize);

        String logMessage = String.format("[%s] Received UDP packet from %s:%d | Size: %d bytes | Data: %s", timestamp, sourceIP, sourcePort, packetSize, data);
        System.out.println(logMessage);
        writeLogFile(logMessage);
    }

    private static void writeLogFile(String logMessage){
        try (FileWriter writer = new FileWriter("udp_log.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(logMessage);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
