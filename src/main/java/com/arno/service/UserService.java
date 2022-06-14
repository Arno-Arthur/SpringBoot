package com.arno.service;

import com.arno.dao.UserDao;
import com.arno.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User getByLoginAndPassword(String login, String password) {
        return userDao.getByLoginAndPassword(login,password);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }
}
