package com.wsk.test;

import com.wsk.pojo.Users;
import com.wsk.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BachAddUsersTest {
    public static void main(String[] args) {
        //启动Spring ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("opplicationContext.xml");
        //从Ioc容器中获取
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        Users users = new Users();
        users.setUsername("高清");
        users.setUsersex("男");
        Users users1 = new Users();
        users1.setUsername("xaiowu");
        users1.setUsersex("nv");
        List<Users> list = new ArrayList<>();
        list.add(users);
        list.add(users1);
        usersService.addUsers(list);
    }
}
