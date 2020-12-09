package com.wsk.dao;

import com.wsk.pojo.Users;

import java.util.List;

public interface UsersDao {
    //添加单条信息
    int insertUsers(Users users);
    //添加批量信息
    int[] batchInsertUsers(List<Users> users);
    //查询返回单条数据
    Users selectUsersById(int userid);
    //查询返回多条数据
    List<Users> selectUsersByname(String username);
    //查询多条数据的简化版
    List<Users> selectUsersByName2(String username);
}
