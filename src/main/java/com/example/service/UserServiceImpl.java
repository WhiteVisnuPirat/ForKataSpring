package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}