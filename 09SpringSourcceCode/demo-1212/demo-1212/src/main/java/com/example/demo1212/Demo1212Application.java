package com.example.demo1212;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*

你的所有要被扫描的包，都必须放在spring主应用同包或者子包下！  为什么？
 */

// @SpringBootApplication   SpringBoot的应用，标注了这个注解就是SpringBoot应用了
@SpringBootApplication  //自动配置，怎么配置的
public class Demo1212Application {

    public static void main(String[] args) {
        //你以为执行了一个方法，开启了一个服务！
        // 构造器，初始化操作
        // run 开启了服务
        SpringApplication.run(Demo1212Application.class, args);
    }

}
