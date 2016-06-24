package com.tianchang.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tianchang.supper.dao.SupperDao;
import com.tianchang.tgb.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-common.xml")
public class UserTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SupperDao userDao;

    @Test
    public void testAdd() {
        User user = new User(-1, "23", "jiuqiyuliang1");
        int num = userDao.save("userDao.save", user);
        System.out.println(num);

    }

    @Test
    public void testFindAll() {
        List<User> findAllList = userDao.findList("userDao.findAll");
        System.out.println(findAllList.size());
    }

    @Test
    public void testFindById() {
        User user = userDao.get("userDao.findById", 3);
        System.out.println(user.getId());
        System.out.println(user.getUserName());
    }

    @Test
    public void testUpdate() {
        User user = new User(2, "23", "yuliang111");
        int num = userDao.update("userDao.update", user);
        System.out.println(num);
    }

    @Test
    public void testDelete() {
        int num = userDao.delete("userDao.delete", 1);
        System.out.println(num);
    }
}
