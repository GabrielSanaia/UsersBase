package com.example.UsersBase.Service;

import com.example.UsersBase.Model.Role;
import com.example.UsersBase.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(User user);

    void editUser(User user);

    public List<User> getUsers(String name);

    public List<User> getUsers(Role role);

    public Page<User> getUsersPage(int page, int usersOnPage);


}
