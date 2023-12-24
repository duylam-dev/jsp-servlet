package com.javaweb.Dao;

import com.javaweb.Model.UserModel;

public interface IUserDao extends GenericDao<UserModel> {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
