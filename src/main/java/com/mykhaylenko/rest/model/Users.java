package com.mykhaylenko.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pavlo.Mykhaylenko on 5/10/2016.
 */
@XmlRootElement(name = "users")
public class Users implements Serializable {

    private List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
