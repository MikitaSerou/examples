package data.dao;

import java.util.List;

public interface AbstractDao<T, I> {

    void save(T entity);

    T findOne(I id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);
}
