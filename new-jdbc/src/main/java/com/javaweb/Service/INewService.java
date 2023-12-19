package com.javaweb.Service;

import com.javaweb.Model.NewModel;
import com.javaweb.paging.Pageble;

import java.util.List;

public interface INewService {
    List<NewModel> findByCategoryId(Long categoryId);
    NewModel save(NewModel newModel);
    void delete(List<Long> id);
    NewModel update(NewModel updateNew);
    List<NewModel> findAll(Pageble pageble);
    int getTotalItem();
}
