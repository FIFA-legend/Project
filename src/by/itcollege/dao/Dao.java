package by.itcollege.dao;

public interface Dao<T> {

    T findById(int id);

    void update(int id, T dao);

    void delete(int id);

}
