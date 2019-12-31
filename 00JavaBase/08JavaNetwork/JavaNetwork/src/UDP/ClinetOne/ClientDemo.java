package UDP.ClinetOne;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);

        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            ds.receive(dp);

            InetAddress address = dp.getAddress();
            int port = dp.getPort();

            byte[] bysReceive = dp.getData();
            DatagramPacket p = new DatagramPacket(bysReceive, bysReceive.length, address, port);
            ds.send(p);
        }

    }
}
