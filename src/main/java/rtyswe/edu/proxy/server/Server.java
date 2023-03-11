package rtyswe.edu.proxy.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataInputStream in;
    private static DataOutputStream out;
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(5000)) {
            while (true) {
                Socket client = server.accept();
                try {
                    in = new DataInputStream(client.getInputStream());
                    out = new DataOutputStream(client.getOutputStream());

                    double val1 = in.readDouble();
                    double val2 = in.readDouble();

                    out.writeDouble(val1 * val2);
                } finally {
                    client.close();
                    in.close();
                    out.close();
                }
            }
        }
    }

}
