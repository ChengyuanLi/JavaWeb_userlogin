package com.service;

import com.dao.UserDao;
import com.domain.User;

/**
 * @author aidenli
 */
public class UserService {

    private UserService() {}
    private static UserService service = new UserService();
    public static UserService getInstance() {
        return service;
    }

    public User checkLogin (String uname, String upass) {
        UserDao userDao = UserDao.getInstance();
        return userDao.findUserByNameAndPass(uname, upass);
    }
}
