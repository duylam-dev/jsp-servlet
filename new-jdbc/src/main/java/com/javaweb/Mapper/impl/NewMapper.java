package com.javaweb.Mapper.impl;

import com.javaweb.Mapper.RowMapper;
import com.javaweb.Model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewModel> {
    @Override
    public NewModel MapRow(ResultSet rs) {
        NewModel newModel = new NewModel();
        try {
            newModel.setId(rs.getLong("id"));
            newModel.setTitle(rs.getString("title"));
            newModel.setThumbnail(rs.getString("thumbnail"));
            newModel.setShortDescription(rs.getString("shortdescription"));
            newModel.setContent(rs.getString("content"));
            newModel.setCategoryId(rs.getLong("categoryid"));
            newModel.setCreatedDate(rs.getTimestamp("createddate"));
            newModel.setCreatedBy(rs.getString("createdby"));
            if(rs.getTimestamp("modifieddate") != null){
                newModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if(rs.getString("modifiedby") != null){
                newModel.setModifiedBy(rs.getString("modifiedby"));
            }
            return newModel;
        }catch (SQLException e){
            return null;
        }
    }
}
