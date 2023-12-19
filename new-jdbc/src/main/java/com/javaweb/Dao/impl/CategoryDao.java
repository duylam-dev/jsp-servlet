package com.javaweb.Dao.impl;

import com.javaweb.Dao.ICategoryDao;
import com.javaweb.Mapper.impl.CategoryMapper;
import com.javaweb.Model.CategoryModel;


import java.util.List;


public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao{
    @Override
    public List<CategoryModel> findAll() {
        String sql = "select * from category";
        return Query(sql, new CategoryMapper());
    }

    @Override
    public Long save(CategoryModel categoryModel) {
        String sql = "insert into category(name, code) values(?,?)";
        return insert(sql,categoryModel.getName(), categoryModel.getCode());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from category where id = ?";
        update(sql,id);
    }
}
