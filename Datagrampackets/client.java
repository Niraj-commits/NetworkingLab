package Datagrampackets;

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
            ds.send(dp);
            ds.receive(receive);
            System.out.println("Data Received : " + Arrays.toString(receive.getData()));
            ds.setSoTimeout(100);
            ds.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
