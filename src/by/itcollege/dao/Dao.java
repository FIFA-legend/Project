package by.itcollege.dao;

import by.itcollege.entity.Car;

public interface Dao<T> {

    void save(T dao);

    T findById(int id);

    void update(int id, T dao);

    void delete(int id);

}
