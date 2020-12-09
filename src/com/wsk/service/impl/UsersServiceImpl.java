package com.wsk.service.impl;

import com.wsk.dao.UsersDao;
import com.wsk.pojo.Users;
import com.wsk.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public int addUsers(Users users) {
        return this.usersDao.insertUsers(users);
    }

    @Override
    public int[] addUsers(List<Users> users) {
        return this.usersDao.batchInsertUsers(users);
    }

    @Override
    public Users findUsersByid(int userid) {
        return this.usersDao.selectUsersById(userid);
    }

    @Override
    public List<Users> findUsersByName(String username) {
        return this.usersDao.selectUsersByname(username);
    }

    @Override
    public List<Users> findUsersByName2(String username) {
        return this.usersDao.selectUsersByName2(username);
    }

}
