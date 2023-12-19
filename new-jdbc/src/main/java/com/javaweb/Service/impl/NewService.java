package com.javaweb.Service.impl;

import com.javaweb.Dao.INewDao;
import com.javaweb.Model.NewModel;
import com.javaweb.Service.INewService;
import com.javaweb.paging.Pageble;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDao newDao;
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        return newDao.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newModel.setCreatedBy("");
        Long newId = newDao.save(newModel);
        return newDao.findOne(newId);
    }

    @Override
    public void delete(List<Long> id){
        for(Long i : id){
            newDao.delete(i);
        }
    }

    @Override
    public NewModel update(NewModel updateNew) {
        NewModel oldIdNew = newDao.findOne(updateNew.getId());
        updateNew.setCreatedDate(oldIdNew.getCreatedDate());
        updateNew.setCreatedBy(oldIdNew.getCreatedBy());
        updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNew.setModifiedBy("");
        newDao.update(updateNew);
        return newDao.findOne(updateNew.getId());
    }

    @Override
    public List<NewModel> findAll(Pageble pageble) {
        return newDao.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return newDao.getTotalItem();
    }


}
