package com.wsk.test;

import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FindUsersByName2Test {
    public static void main(String[] args) {
        //启动Spring ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("opplicationContext.xml");
        //从Ioc容器中获取
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        List<Users> list = usersService.findUsersByName("bjsxt");
        list.forEach(System.out::println);
    }
}
