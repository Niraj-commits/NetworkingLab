package Lab_Work.lab6_chat_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running on port 5000");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String inputLine, outputLine;
        while ((inputLine = reader.readLine()) != null) {
            System.out.println("Client sent: " + inputLine);
            outputLine = "Server sent: " + inputLine;
            writer.println(outputLine);
            if (outputLine.equals("Bye"))
                break;
        }

        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
