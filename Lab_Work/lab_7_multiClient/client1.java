package Lab_Work.lab_7_multiClient;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket client = new Socket("localhost", 8000);

            while (true) {
                System.out.println("Enter Text: ");
                String Output = sc.nextLine();

                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(Output);

                DataInputStream dis = new DataInputStream(client.getInputStream());
                String input = dis.readUTF();
                System.out.println("Server is Saying: " + input);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
