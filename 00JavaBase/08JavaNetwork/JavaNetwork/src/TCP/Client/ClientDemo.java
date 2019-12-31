package TCP.Client;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("127.0.0.1",2345);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line=null;
        while ((line=br.readLine())!=null){
            if("over".equals(line.toLowerCase())){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        s.close();
    }
}
