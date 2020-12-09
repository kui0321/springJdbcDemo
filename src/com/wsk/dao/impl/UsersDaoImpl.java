package com.wsk.dao.impl;

import com.wsk.dao.UsersDao;
import com.wsk.pojo.Users;
import org.springframework.jdbc.core.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoImpl implements UsersDao {

    private JdbcTemplate jdbcTemplate; //配置持久层的依赖注入
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 单挑添加用户
     * @param users
     * @return
     */
    @Override
    public int insertUsers(Users users) {
        String sql = "insert into users values (default , ?, ?)";
        Object[] pareams = new Object[]{users.getUsername(), users.getUsersex()};
        return this.jdbcTemplate.update(sql, pareams);
    }

    /**
     * 批量添加用户
     * @param users
     * @return
     */
    @Override
    public int[] batchInsertUsers(List<Users> users) {
        String sql = "insert into users values (default ,?, ?)";
        BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter(){

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Users temp = users.get(i);
                preparedStatement.setString(1, temp.getUsername());
                preparedStatement.setString(2,temp.getUsersex());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        };
        return this.jdbcTemplate.batchUpdate(sql, setter);
    }

    /**
     * 查询返回单条数据的信息
     * @param userid
     * @return
     */
    @Override
    public Users selectUsersById(int userid) {
        String sql = "select * from users where userid = ?";
        Object[] params = new Object[]{userid};
        Users users = new Users();
        this.jdbcTemplate.query(sql, params, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                users.setUserid(resultSet.getInt("userid"));
                users.setUsername(resultSet.getString("username"));
                users.setUsersex(resultSet.getString("usersex"));
            }
        });
        return users;
    }

    /**
     * 查询返回多条数据
     * @param username
     * @return
     */
    @Override
    public List<Users> selectUsersByname(String username) {
        String sql = "select * from users where username = ?";
        Object[] param =new Object[]{username};
        return this.jdbcTemplate.query(sql, param, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users users = new Users();
                users.setUserid(resultSet.getInt("userid"));
                users.setUsername(resultSet.getString("username"));
                users.setUsersex(resultSet.getString("usersex"));
                return users;
            }
        });
    }

    /**
     * 查询多条数据的简化方法
     * @param username
     * @return
     */
    @Override
    public List<Users> selectUsersByName2(String username) {
        String sql = "select * from  users where username = ?";
        Object[] param = new Object[]{username};
        //通过BeanPropertyRowMapper完成对对象的映射处理
        return this.jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<>(Users.class));
    }

}
