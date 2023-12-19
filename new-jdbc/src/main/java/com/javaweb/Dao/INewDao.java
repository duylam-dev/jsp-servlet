package com.javaweb.Dao;

import com.javaweb.Model.NewModel;
import com.javaweb.paging.Pageble;

import java.util.List;

public interface INewDao extends GenericDao<NewModel> {
    NewModel findOne(Long id);
    List<NewModel> findByCategoryId(Long categoryId);
    Long save(NewModel newModel);
    void delete(Long id);
    void update(NewModel updateNew);
    List<NewModel> findAll(Pageble pageble);
    int getTotalItem();
}
