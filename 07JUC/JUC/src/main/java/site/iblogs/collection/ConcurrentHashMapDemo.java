package site.iblogs.collection;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        Map<String,String> map=new ConcurrentHashMap<>(100);

        for (int i=0;i<30;i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString());
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
