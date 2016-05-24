package com.mykhaylenko.rest.fakeservice;

import com.mykhaylenko.rest.model.User;

import java.util.List;

/**
 * Created by Pavlo.Mykhaylenko on 5/6/2016.
 */
public interface UserService {

    User getUser(int index);

    List<User> getAllUsers();

    User saveUser(User user);

    User updateUser(User user);

    User deleteUser(int id);
}
