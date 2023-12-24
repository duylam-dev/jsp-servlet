package com.javaweb.Dao.impl;

import com.javaweb.Dao.IUserDao;
import com.javaweb.Mapper.impl.UserMapper;
import com.javaweb.Model.UserModel;

import java.util.List;


public class UserDao extends AbstractDao<UserModel> implements IUserDao {

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        StringBuilder sql = new StringBuilder("select * from user as u");
        sql.append(" inner join role as r on r.id = u.roleid");
        sql.append(" where username = ? and password = ? and status = ?");
        List<UserModel> users = Query(sql.toString(),new UserMapper(), userName, password, status);
        return users.isEmpty() ? null : users.get(0);
    }
}
