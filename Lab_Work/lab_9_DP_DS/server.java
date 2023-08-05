package Lab_Work.lab_9_DP_DS;

import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1234);
            byte[] buffer;
            buffer = new byte[2];
            byte[] send = { 6, 9 };

            DatagramPacket dp = new DatagramPacket(buffer, 2);
            ds.receive(dp);
            DatagramPacket senddp = new DatagramPacket(send, 2, dp.getAddress(), dp.getPort());
            ds.send(senddp);
            ds.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
