package com.mykhaylenko.rest.client;

import com.mykhaylenko.rest.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Pavlo.Mykhaylenko on 5/10/2016.
 */
@Component
public class Client {

    public User fetchUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082/springrest-1.0-SNAPSHOT/users/{id}", User.class, id);
    }

    public String saveUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForLocation("http://localhost:8082/springrest-1.0-SNAPSHOT/users/save", user).toString();
    }
}
