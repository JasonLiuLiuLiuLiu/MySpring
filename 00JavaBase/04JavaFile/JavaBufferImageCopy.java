import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaBufferImageCopy {
    public static void main(String[] args) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream("logo.bmp"));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("copy.bmp"));
        byte[] bys=new byte[1024];
        int leng=0;
        while((leng=reader.read(bys))!=-1){
            output.write(bys,0,leng);
        }
        reader.close();
        output.close();
    }
}