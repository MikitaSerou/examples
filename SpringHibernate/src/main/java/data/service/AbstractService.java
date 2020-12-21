package data.service;

import java.util.List;

public interface AbstractService<T, I> {

    void add(T entity);
    T findOne(I id);
    List<T> list();
    void update(T entity);
    void delete(T entity);

}
