package Lab_Work;

import java.net.URI;
import java.net.URISyntaxException;

public class lab_5 {
    public static void main(String[] args) {
        try {
            // Creating URI object
            URI uri1 = new URI("https", "example.com", "/path/to/resource", "param1=value1&param2=value2", "fragment");

            // Retrieving different components of URI
            System.out.println("URI 1 Scheme: " + uri1.getScheme());
            System.out.println("URI 1 Host: " + uri1.getHost());
            System.out.println("URI 1 Path: " + uri1.getPath());
            System.out.println("URI 1 Query: " + uri1.getQuery());
            System.out.println("URI 1 Fragment: " + uri1.getFragment());
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }
}
