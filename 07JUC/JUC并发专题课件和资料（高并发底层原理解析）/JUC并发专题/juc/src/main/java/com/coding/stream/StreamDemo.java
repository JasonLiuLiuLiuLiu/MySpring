package com.coding.stream;

import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 一下数据，进行操作筛选用户：要求：一行代码做出此题，时长1分钟！
 * 1、全部满足偶数ID
 * 2、年龄都大于24
 * 3、用户名转为大写
 * 4、用户名字母倒排序
 * 5、只能输出一个名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        // 集合管理数据
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        // 计算交给Stream
        // 过滤  filter
        // 映射 map
        // 排序， sort
        // 分页   limit
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>24;})
                .map(u->{return u.getUsername().toUpperCase();})
                .sorted((o1,o2)->{return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);

        // 泛型、注解、反射
        // 链式编程 + 流式计算 + lambda表达式


        // ForkJoinPool 执行
        // ForkJoinTask
                // recursive

        // WorkQueue
    }
}
