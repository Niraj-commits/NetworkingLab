package Cookies;

import java.net.*;
import java.util.*;

public class storeCookies {
    public static void main(String[] args) {

        try {
            CookieManager manager = new CookieManager();
            CookieStore cookiestore = manager.getCookieStore();
            HttpCookie cookieA = new HttpCookie("c1", "Niraj");
            HttpCookie cookieB = new HttpCookie("c2", "Karki");

            URI uri1 = new URI("www.abc.com");
            URI uri2 = new URI("www.xyz.com");

            cookiestore.add(uri1, cookieA);
            cookiestore.add(uri2, cookieB);

            List<HttpCookie> list = cookiestore.getCookies();
            System.out.println("Store Cookies: " + list);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}