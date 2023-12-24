package com.javaweb.Mapper.impl;

import com.javaweb.Mapper.RowMapper;
import com.javaweb.Model.RoleModel;
import com.javaweb.Model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel MapRow(ResultSet rs) {
        UserModel userModel = new UserModel();
        try {
            userModel.setUserName(rs.getString("username"));
            userModel.setPassword(rs.getString("password"));
            userModel.setFullName(rs.getString("fullname"));
            userModel.setStatus(rs.getInt("status"));
            //role
            RoleModel roleModel = new RoleModel();
           try{
               roleModel.setCode(rs.getString("code"));
               roleModel.setName(rs.getString("name"));
               userModel.setRole(roleModel);
           }catch (Exception e){
               System.out.println(e.getMessage());
           }

            return userModel;
        }catch (SQLException e){
            return null;
        }
    }
}
