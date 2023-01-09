package com.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("JdbcTemplate.xml");
        DataOperate per = ac.getBean("dataOperate", DataOperate.class);
      //  per.createTable();
      //  per.insertData();
       // per.selectOne();
      //  per.selectObj();
        per.selectList();

    }
}
