package com.example.placeholderviewer.data.database.daos;

import com.example.placeholderviewer.data.database.base.DbEntity;
import java.util.List;

public interface BaseDAO<T extends DbEntity> {

    T select(Long id);

    List<T> select();

    T insert(T item);

    boolean update(T item);

    boolean delete(T item);

    List<T> selectByIdElement(Long idElement);

}
