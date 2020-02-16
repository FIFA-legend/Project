package by.itcollege.dao;

import by.itcollege.entity.User;

public interface UserDao {

    void save(User user);

    User read(int id);

    void update(int id, User user);

    void delete(int id);

}
