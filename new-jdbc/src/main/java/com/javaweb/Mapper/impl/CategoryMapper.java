package com.javaweb.Mapper.impl;

import com.javaweb.Mapper.RowMapper;
import com.javaweb.Model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel MapRow(ResultSet rs) {
        CategoryModel categoryModel = new CategoryModel();
        try{
            categoryModel.setId(rs.getLong("id"));
            categoryModel.setCode(rs.getString("code"));
            categoryModel.setName(rs.getString("name"));
            return categoryModel;
        }catch (SQLException e){
            return null;
        }
    }
}
