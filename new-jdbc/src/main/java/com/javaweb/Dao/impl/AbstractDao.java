package com.javaweb.Dao.impl;

import com.javaweb.Dao.GenericDao;
import com.javaweb.Mapper.RowMapper;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class AbstractDao<T> implements GenericDao<T> {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    public Connection getConnection(){
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String userName = resourceBundle.getString("user");
            String passWord = resourceBundle.getString("password");
            return DriverManager.getConnection(url,userName,passWord);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    private void setParameters(PreparedStatement statement,Object... parameters){
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<T> Query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(sql);
            //set parameter
            setParameters(statement,parameters);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                results.add(rowMapper.MapRow(resultSet));
            }
            return results;
        }catch (SQLException e){
            return null;
        }finally {
            try {
                connection.close();
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameters(statement,parameters);
            statement.executeUpdate();
            connection.commit();
        }catch (SQLException e){
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Long id = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
            setParameters(statement,parameters);
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
            connection.commit();
            return id;
        }catch (SQLException e){
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    return null;
                }
            }
            return null;
        }finally {
            try {
                connection.close();
                if(statement != null){
                    statement.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e2) {
                return null;
            }
        }
    }

    @Override
    public int count(String sql, Object... parameters) {
        int count = 0;
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(sql);
            //set parameter
            setParameters(statement,parameters);
            resultSet = statement.executeQuery();
            if(resultSet.next()) count = resultSet.getInt(1);
            return count;
        }catch (SQLException e){
            return 0;
        }finally {
            try {
                connection.close();
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }

}
