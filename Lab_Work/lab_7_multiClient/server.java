package Lab_Work.lab_7_multiClient;

import java.net.*;
import java.io.*;

public class server {
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(8000);
            Socket client;
            System.out.println("Waiting for client ...");
            while (true) {
                client = server.accept();
                String output = "You are connected to the Server!";
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(output);

                MultipleClient multiClientObj = new MultipleClient(client);
                Thread th = new Thread(multiClientObj, "client_thread");
                th.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static class MultipleClient implements Runnable {
        Socket client;

        MultipleClient(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                while (true) {
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    String input = dis.readUTF();
                    System.out.println(input);

                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                    dos.writeUTF("Msg received by server");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
