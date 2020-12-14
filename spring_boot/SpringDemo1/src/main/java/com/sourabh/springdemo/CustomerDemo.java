package com.sourabh.springdemo;

import com.sourabh.bean.Customer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class CustomerDemo {
    public static void main(String[] args) {
        BeanFactory container = new FileSystemXmlApplicationContext("beans_company.xml");
        Customer customerS = (Customer) container.getBean("customerSetter");
        System.out.println("Setters: "+customerS);

        Customer customerC  = (Customer) container.getBean("customerConstructor");
        System.out.println("Constructor: "+customerC);

    }
}
