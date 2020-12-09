package com.wsk.dao.impl;

import com.wsk.dao.UsersDao;
import com.wsk.pojo.Users;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class UsersDaoIpmlSupport extends JdbcDaoSupport implements UsersDao {

    @Override
    public int insertUsers(Users users) {
        return 0;
    }

    @Override
    public int[] batchInsertUsers(List<Users> users) {
        return new int[0];
    }

    @Override
    public Users selectUsersById(int userid) {
        return null;
    }

    @Override
    public List<Users> selectUsersByname(String username) {
        return null;
    }

    @Override
    public List<Users> selectUsersByName2(String username) {
        return null;
    }
}
