package Lab_Work.lab6_chat_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server on port 5000");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String inputLine, outputLine;
        while ((inputLine = userInput.readLine()) != null) {
            writer.println(inputLine);
            if ((outputLine = reader.readLine()) != null) {
                System.out.println("Server sent: " + outputLine);
            }
            if (inputLine.equals("Bye"))
                break;
        }

        writer.close();
        reader.close();
        socket.close();
    }
}
