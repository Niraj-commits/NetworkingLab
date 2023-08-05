package Lab_Work.lab_9_DP_DS;

import java.net.*;
import java.util.Arrays;

public class client {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            int port = 1234;
            byte[] buffer1 = { 12, 13 };
            byte[] buffer2 = new byte[2];

            DatagramPacket dp = new DatagramPacket(buffer1, 2, add, port);
            DatagramPacket receive = new DatagramPacket(buffer2, 2);
            ds.connect(add, port);
            System.out.println("Bound : " + ds.isBound());
            System.out.println("connected : " + ds.isConnected());
            System.out.println("InetAddress : " + ds.getInetAddress());
            System.out.println("Port : " + ds.getPort());
            System.out.println("Remote Socket : " + ds.getRemoteSocketAddress());
            System.out.println("Local Socket : " + ds.getLocalSocketAddress());
            ds.send(dp);
            System.out.println("Data Packet Sent : ");
            ds.receive(receive);
            System.out.println("Data Received : " + Arrays.toString(receive.getData()));
            System.out.println("Local Host : " + ds.getLocalPort());
            ds.setSoTimeout(100);
            ds.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
