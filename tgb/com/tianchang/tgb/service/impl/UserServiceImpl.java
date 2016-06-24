package com.tianchang.tgb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianchang.supper.dao.SupperDao;
import com.tianchang.tgb.model.User;
import com.tianchang.tgb.service.UserService;

@Service
@Transactional
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {

    @Autowired
    private SupperDao userDao;

    public int delete(int id) {
        return userDao.delete("userDao.delete", id);
    }

    public List<User> findAll() {
        List<User> findAllList = userDao.findList("userDao.findAll");
        return findAllList;
    }

    public User findById(int id) {
        User user = userDao.get("userDao.findById", id);
        return user;
    }

    public int save(User user) {
        return userDao.save("userDao.save", user);

    }

    public int update(User user) {
        return userDao.update("userDao.update", user);
    }

}
