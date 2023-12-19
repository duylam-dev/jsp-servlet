package com.javaweb.Service;

import com.javaweb.Model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    void delete(Long id);
    Long save(CategoryModel categoryModel);
}
