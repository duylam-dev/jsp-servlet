package com.javaweb.Dao;

import com.javaweb.Mapper.RowMapper;


import java.util.List;
import java.lang.Object;

public interface GenericDao<T> {
    List<T> Query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update(String sql, Object... parameters);
    Long insert(String sql,Object... parameters);
    int count(String sql, Object... parameters);
}
