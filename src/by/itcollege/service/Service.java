package by.itcollege.service;

import java.util.List;

public interface Service<T> {

    int save(T entity);

    T findById(int id);

    void update(T dao);

    void delete(int id);

}

