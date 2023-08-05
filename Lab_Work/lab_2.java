package Lab_Work;

import java.net.*;
import java.io.*;

public class lab_2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com/");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        StringBuilder content = new StringBuilder();

        while ((line = br.readLine()) != null)
            content.append(line).append("\n");
        br.close();

        FileWriter fw = new FileWriter("Myfile.html");
        fw.write(content.toString());
        fw.close();
    }
}
