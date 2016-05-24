package com.mykhaylenko.rest.fakeservice.impl;

import com.mykhaylenko.rest.fakeservice.UserService;
import com.mykhaylenko.rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavlo.Mykhaylenko on 5/6/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    private List<User> users =  new ArrayList<>();

    public UserServiceImpl() {
        users.add(null);
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setFirstName("firstName" + i);
            user.setSecondName("secondName" + i);
            user.setSalary(5400.21 + i);
            user.setBirthDay(new Date());
            users.add(user);
        }
    }

    @Override
    public User getUser(int index) {
        return users.get(index);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User saveUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = users.get(user.getId());
        updatedUser.setId(user.getId());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setSecondName(user.getSecondName());
        updatedUser.setSalary(user.getSalary());
        updatedUser.setBirthDay(user.getBirthDay());
        return updatedUser;
    }

    @Override
    public User deleteUser(int id) {
        return users.remove(id);
    }
}
