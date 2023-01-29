package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.exception.DtoException;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(User user) {
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(()
                -> new DtoException("Can not get user with id " + id));
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(()
                -> new DtoException("Can`t find user with email " + email));
    }
}
