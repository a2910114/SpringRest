package com.mykhaylenko.rest.controller;

import com.mykhaylenko.rest.client.Client;
import com.mykhaylenko.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Pavlo.Mykhaylenko on 5/10/2016.
 */
@Controller
@RequestMapping("/fetch")
public class ClientController {

    @Autowired
    private Client client;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserName(@PathVariable int id) {
        return client.fetchUser(id).getFirstName();
    }

    @RequestMapping(value = "/saved", method = RequestMethod.GET)
    @ResponseBody
    public String getSavedUserUrl() {
        User user = new User();
        user.setId(10);
        user.setFirstName("first");
        user.setSecondName("second");
        user.setSalary(234);
        user.setBirthDay(new Date());
        return client.saveUser(user);
    }
}
