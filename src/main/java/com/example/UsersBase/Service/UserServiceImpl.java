package com.example.UsersBase.Service;

import com.example.UsersBase.Exception.DuplicateNameException;
import com.example.UsersBase.Model.*;
import com.example.UsersBase.Repository.PersonRepository;
import com.example.UsersBase.Repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonService personService;

    @Autowired
    RoleService roleService;



    @Override
    public void addUser(User user) {

        if (user.getRole() != null && user.getRole().getId() != null) {
            Role role = roleService.getRoleById(user.getRole().getId());
            user.setRole(role);
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }

    @Override
    public void editUser(User user) {
        User entity = userRepository.findById(user.getId()).get();

        if(user.getUsername() != null)
            entity.setUsername(user.getUsername());

        if(user.getPassword() != null)
            entity.setPassword(user.getPassword());

        if(user.getRole() != null)
            entity.setRole(user.getRole());

        userRepository.save(entity);
    }

    @JsonManagedReference
    @Override
    public List<User> getUsers(String username) {
        User user = new User();
        user.setUsername(username);

        Example<User> example = Example.of(user);

        List<User> users = userRepository.findAll(example);

        return users;
    }

    @Override
    public List<User> getUsers(Role role) {

        User user = new User();
        user.setRole(role);

        Example<User> example = Example.of(user);

        List<User> users = userRepository.findAll(example);
        return users;
    }

    @Override
    public Page<User> getUsersPage(int page, int usersOnPage) {

        return userRepository.findAll(PageRequest.of(page,usersOnPage, Sort.Direction.ASC, "username"));
    }
}
