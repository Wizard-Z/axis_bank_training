package com.sourabh.springdemo;

import com.sourabh.bean.Line;
import com.sourabh.bean.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ShapeApplication {
    public static void main(String[] args) {
        BeanFactory container = new FileSystemXmlApplicationContext("beans.xml");
        Line line = (Line) container.getBean("Line");
        System.out.println("The Line is: "+line);

        Triangle triangle = (Triangle) container.getBean("triangle");
        System.out.println("The Triangle is: "+triangle);

    }
}
