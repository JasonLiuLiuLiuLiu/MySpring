import java.io.File;

public class JavaFile {
    public static void main(String[] args) {
        File file = new File("c:\\mybox");
        showFiles(file);
    }

    public static void showFiles(File file) {
        for (File item : file.listFiles()) {
            if (item.isDirectory()) {
                showFiles(item);
            } else {
                if (item.getName().endsWith(".mp4")) {
                    System.out.println(item.getAbsolutePath());
                }
            }
        }
    }
}