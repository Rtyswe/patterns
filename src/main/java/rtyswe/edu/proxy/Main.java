package rtyswe.edu.proxy;

import rtyswe.edu.proxy.client.Proxy;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(Proxy.multiple(12, 12));
    }

}
