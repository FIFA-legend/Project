package by.itcollege.service;

import by.itcollege.dao.UserDaoImpl;
import by.itcollege.entity.User;

import java.util.List;

public class UserService implements Service<User>{

    private static UserService INSTANCE;

    private UserService() {}

    public static  UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) INSTANCE = new UserService();
            }
        }
        return  INSTANCE;
    }

    @Override
    public int save(User user) {
        return UserDaoImpl.newInstance().save(user);
    }

    @Override
    public User findById(int id) {
        return UserDaoImpl.newInstance().findById(id);
    }

    @Override
    public void update(User user) {
        UserDaoImpl.newInstance().update(user.getId(), user);
    }

    @Override
    public void delete(int id) {
        UserDaoImpl.newInstance().delete(id);
    }

    public List<User> getFreeDrivers() {
        return UserDaoImpl.newInstance().findFreeDrivers();
    }
}
