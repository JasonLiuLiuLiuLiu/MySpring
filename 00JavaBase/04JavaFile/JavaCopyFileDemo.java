import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaCopyFileDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("c:\\mybox\\CopyFileDemo.java");
        FileOutputStream output = new FileOutputStream("c:\\mybox\\CopyOutput.java");
        byte[] bys = new byte[1024];
        int leng = 0;
        while ((leng = input.read(bys)) != -1) {
            output.write(bys);
        }
        output.flush();
        output.close();
        input.close();
        input=new FileInputStream("c:\\mybox\\CopyOutput.java");
        while ((leng = input.read(bys)) != -1) {
           System.out.println(new String(bys,0,leng));
        }
        input.close();
    }
}