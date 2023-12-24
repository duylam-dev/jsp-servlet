package com.javaweb.Service.impl;

import com.javaweb.Dao.IUserDao;
import com.javaweb.Model.UserModel;
import com.javaweb.Service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDao userDao;

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
    }
}
