package com.javaweb.Dao;

import com.javaweb.Model.CategoryModel;

import java.util.List;

public interface ICategoryDao extends GenericDao<CategoryModel>{
    List<CategoryModel> findAll();
    Long save(CategoryModel categoryModel);
    void delete(Long id);
}
