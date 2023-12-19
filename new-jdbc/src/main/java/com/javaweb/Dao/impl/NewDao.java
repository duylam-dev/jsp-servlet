package com.javaweb.Dao.impl;

import com.javaweb.Dao.INewDao;
import com.javaweb.Mapper.impl.NewMapper;
import com.javaweb.Model.NewModel;
import com.javaweb.paging.Pageble;

import java.util.List;

public class NewDao extends AbstractDao<NewModel> implements INewDao {
    @Override
    public NewModel findOne(Long id) {
        String sql = "select * from news where id = ?";
        List<NewModel> newModel = Query(sql,new NewMapper(), id);
        return newModel.isEmpty() ? null : newModel.get(0);
    }

    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        String sql = "select * from news where category id = ?";
        return Query(sql,new NewMapper(), categoryId);
    }
    @Override
    public Long save(NewModel newModel) {
        String sql = "insert into news(title, content, categoryid, createddate, createdby) values(?,?,?,?,?)";
       return insert(sql,newModel.getTitle(),newModel.getContent(),newModel.getCategoryId(),
               newModel.getCreatedDate(), newModel.getCreatedBy()
               );
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from news where id = ?";
            update(sql,id);
    }

    @Override
    public void update(NewModel updateNew) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
        sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
        sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(),
                updateNew.getCreatedBy(), updateNew.getModifiedDate(),
                updateNew.getModifiedBy(), updateNew.getId());
    }

    @Override
    public List<NewModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("select * from news");
        if(pageble.getSorter() != null) sql.append(" order by " + pageble.getSorter().getSortName()+ " " + pageble.getSorter().getSortBy());
        if(pageble.getOffset() != null && pageble.getLimit() != null) sql.append(" limit " + pageble.getOffset()+ ", " + pageble.getLimit());
        return Query(sql.toString(),new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from news";
        return count(sql);
    }
}
