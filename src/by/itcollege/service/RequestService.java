package by.itcollege.service;

import by.itcollege.dao.RequestDaoImpl;
import by.itcollege.entity.Request;

public class RequestService {

    private static RequestService INSTANCE;

    public static  RequestService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) INSTANCE = new RequestService();
            }
        }
        return  INSTANCE;
    }

    public boolean createRequest(Request request) {
        return RequestDaoImpl.newInstance().save(request);
    }
}
