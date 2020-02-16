package by.itcollege.dao;

import by.itcollege.entity.Request;

public interface RequestDao {

    void save(Request request);

    Request read(int id);

    void update(int id, Request request);

    void delete(int id);

}
