package Lab_Work;

import java.net.*;
// import java.io.*;

public class lab_3 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com/");
        URLConnection conn = url.openConnection();

        for (int i = 1;; i++) {
            String headerKey = conn.getHeaderFieldKey(i);
            String headerValue = conn.getHeaderField(i);

            if (headerKey == null && headerValue == null) {
                break;
            }
            System.out.println(headerKey + ": " + headerValue);
        }
    }

}
