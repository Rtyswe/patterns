package rtyswe.edu.proxy.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Proxy {

    public static double multiple(double val1, double val2) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            out.writeDouble(val1);
            out.writeDouble(val2);

            return in.readDouble();
        }

    }

}
