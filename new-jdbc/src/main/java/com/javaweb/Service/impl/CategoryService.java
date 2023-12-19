package com.javaweb.Service.impl;

import com.javaweb.Dao.ICategoryDao;
import com.javaweb.Dao.impl.CategoryDao;
import com.javaweb.Model.CategoryModel;
import com.javaweb.Service.ICategoryService;

import javax.inject.Inject;
import java.util.List;


public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDao categoryDao;
    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryDao.delete(id);
    }

    @Override
    public Long save(CategoryModel categoryModel) {
        return categoryDao.save(categoryModel);
    }
}
