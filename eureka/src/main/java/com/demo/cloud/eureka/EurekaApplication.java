package com.demo.cloud.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.io.ObjectInputFilter;

@SpringBootApplication
public class EurekaApplication {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
        SpringApplication.run(EurekaApplication.class, args);


        System.out.println("jjjjjjjjjjjjj"+app.getBean("beanDemoImp"));
    }

}
