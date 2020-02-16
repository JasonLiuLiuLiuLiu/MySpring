package site.iblogs.collection;

import java.util.ArrayList;
import java.util.UUID;

public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();

        for (int i=0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
