package com.demo.cloud.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Test {
    @Resource(name = "beanDemoImp1")
    private BeanDemo beanDemo;

    public static int count = 9;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(app.getBean("beanDemoImp"));
        System.out.println(app.getBean("beanDemoImp1"));
        System.out.println(app.getBean("hot fix commit"));

        Map map = new HashMap();
        map.put(null,null);
        System.out.println(map.get("Str"));
        System.out.println("master branch");
//        Print p = new Print();
//        Thread first = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try{
//                    while (true){
//                        p.printChar("A",Thread.currentThread().getName());
//                        p.printChar("B",Thread.currentThread().getName());
//                        p.printChar("C",Thread.currentThread().getName());
//                    }
//
//
//
//                }catch (Exception e){
//
//                }
//
//            }
//        });
//        Thread second = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//
//                    while (true){
//                        p.printChar("A",Thread.currentThread().getName());
//                        p.printChar("B",Thread.currentThread().getName());
//                        p.printChar("C",Thread.currentThread().getName());
//                    }
//
//                }catch (Exception e){
//
//                }
//
//            }
//        });
//
//        Thread third = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//
//                    while (true) {
//                        p.printChar("A", Thread.currentThread().getName());
//                        p.printChar("B", Thread.currentThread().getName());
//                        p.printChar("C", Thread.currentThread().getName());
//                    }
//                }catch (Exception e){
//
//                }
//            }
//        });
//
//        first.start();
//        second.start();
//        third.start();


    }



}

class Print{
    static int countA = 0;
    static int countB = 0;
    static int countC = 0;
    static int name = 0;
    synchronized public void printChar(String word,String threadName){
        name = name%3;
        String str = "Thread-"+name;
        if (!str.equals(threadName)){
            try {
                wait();
            }catch (Exception e){

            }

        }
        if (word.equals("A") && str.equals(threadName) && countA<3){
            System.out.println(word);
            System.out.println("当前线程+++++"+threadName);
            countA++;
            name++;
        }
        if (word.equals("B") && str.equals(threadName)&& countB<3 && countA==3){
            System.out.println(word);
            System.out.println("当前线程+++++"+threadName);

            countB++;
            name++;
        }
        if (word.equals("C") && str.equals(threadName)&& countC<3&& countA==3&& countB==3){
            System.out.println(word);
            System.out.println("当前线程+++++"+threadName);

            countC++;
            name++;
        }
        notifyAll();
    }
}


