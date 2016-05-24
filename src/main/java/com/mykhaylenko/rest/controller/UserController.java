package com.mykhaylenko.rest.controller;

import com.mykhaylenko.rest.exception.Error;
import com.mykhaylenko.rest.exception.UserNotFoundException;
import com.mykhaylenko.rest.fakeservice.UserService;
import com.mykhaylenko.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Pavlo.Mykhaylenko on 5/5/2016.
 */
@Controller
//@RestController // can be user instead @Controller and @ResponseBody annotations
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * To Produce normally List<User> you need use class Users
     * @return
     */
    @RequestMapping(method = RequestMethod.GET) //produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUsers();
//        return new Users(userService.getAllUsers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)// produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User getUserByIndex(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException("Such user is null");
        }
        return user;
    }

    /**
     * Example of ResponseEntity usage, if method returns ResponseEntity annotation @ResponseBody can be omitted
     * @param id
     * @return
     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<User> getUserByIndex(@PathVariable int id) {
//        User user = userService.getUser(id);
//        HttpStatus httpStatus = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return new ResponseEntity<>(user, httpStatus);
//    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public User saveUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user, UriComponentsBuilder uriBuilder) {
        User createdUser = userService.saveUser(user);
        HttpHeaders httpHeaders = new HttpHeaders();

        URI locationUri = uriBuilder.path("/users/")
                .path("5") //TODO: remove hard code - get id from createdUser
                .build()
                .toUri();

        httpHeaders.setLocation(locationUri);

        ResponseEntity<User> responseEntity = new ResponseEntity<User>(createdUser, httpHeaders, HttpStatus.CREATED);

        return responseEntity;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable(value = "id") int id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@PathVariable(value = "id") int id) {
        return userService.deleteUser(id);
    }


//    @ExceptionHandler({IndexOutOfBoundsException.class, UserNotFoundException.class})
//    public ResponseEntity<Error> userNotFound() {
//        Error error = new Error(1, "Such user doesn't exist. Id is out of range or User is NULL");
//        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler({IndexOutOfBoundsException.class, UserNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error userNotFound() {
        Error error = new Error(1, "Such user doesn't exist. Id is out of range or User is NULL");
        return error;
    }
}
