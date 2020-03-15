package by.itcollege.service;

import by.itcollege.dao.UserDaoImpl;
import by.itcollege.entity.User;

import java.util.List;

public class UserService {

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

    public List<User> getFreeDrivers() {
        return UserDaoImpl.newInstance().findFreeDrivers();
    }

    public int createNewUser(User user) {
        return UserDaoImpl.newInstance().save(user);
    }

    public User findUser(int id) {
        return UserDaoImpl.newInstance().findById(id);
    }

    public void updateUser(User user) {
        UserDaoImpl.newInstance().update(user.getId(), user);
    }
}
