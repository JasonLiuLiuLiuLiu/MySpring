package site.iblogs.collection;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteDemo {
    /*
     * 善于总结：
     * 1、 故障现象： ConcurrentModificationException
     * 2、 导致原因： 多线程操作集合类不安全
     * 3、 解决方案：
     *      List<String> list = new Vector<>(); // Vector 是一个线程安全的类,效率低下  50
     *      List<String> list = Collections.synchronizedList(new ArrayList<>()); // 60
     *      List<String> list = new CopyOnWriteArrayList<>(); // JUC 100 推荐使用
     */

    public static void main(String[] args) {
        // 代码实现
        // ArrayList<Object> list = new ArrayList<>(); // 效率高，不支持并发！
        // List<String> list = new Vector<>(); // Vector 是一个线程安全的类,效率低下  50
        // List<String> list = Collections.synchronizedList(new ArrayList<>()); // 60

        List<String> list=new CopyOnWriteArrayList<>();

        for (int i=0;i<30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        Set<String> set=new CopyOnWriteArraySet<>();

        for (int i=0;i<30;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString());
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
