package UDP.ClientTwo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        String line = null;
        while ((line = br.readLine()) != null) {


            if ("886".equals(line)) {
                break;
            }
            byte[] bys = line.getBytes();
            DatagramPacket p = new DatagramPacket(bys, bys.length, InetAddress.getByName("127.0.0.1"), 10086);

            ds.send(p);

            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            ds.receive(dp);
            System.out.println("receive:" + new String(dp.getData(), 0, dp.getLength()));
        }

        ds.close();
    }
}

