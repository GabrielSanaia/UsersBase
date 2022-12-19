package com.example.UsersBase.Controller;

import com.example.UsersBase.Model.User;
import com.example.UsersBase.Repository.UserRepository;
import com.example.UsersBase.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    @PatchMapping("/user")
    public void editUser(@RequestBody User user){
        userService.editUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestBody User user){
        List<User> users = null;

        if(user.getRole() != null)
            users = userService.getUsers(user.getRole());

        if(user.getUsername() != null)
            users = userService.getUsers(user.getUsername());

        return users;
    }

    @GetMapping("/usersPage")
    public Page<User> getUsersPage(@RequestParam int page, @RequestParam int usersOnPage){
        return userService.getUsersPage(page, usersOnPage);
    }

}
