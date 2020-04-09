package by.itcollege.service;

import by.itcollege.dao.RequestDaoImpl;
import by.itcollege.entity.Request;

public class RequestService implements Service<Request>{

    private static RequestService INSTANCE;

    public static  RequestService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) INSTANCE = new RequestService();
            }
        }
        return  INSTANCE;
    }

    @Override
    public int save(Request request) {
        return RequestDaoImpl.newInstance().save(request);
    }

    @Override
    public Request findById(int id) {
        return RequestDaoImpl.newInstance().findById(id);
    }

    @Override
    public void update(Request dao) {
        RequestDaoImpl.newInstance().update(dao.getId(), dao);
    }

    @Override
    public void delete(int id) {
        RequestDaoImpl.newInstance().delete(id);
    }
}
