package com.example.UsersBase.Controller;

import com.example.UsersBase.Exception.DuplicateNameException;
import com.example.UsersBase.Model.Role;
import com.example.UsersBase.Repository.RoleRepository;
import com.example.UsersBase.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    public void addRole(@RequestBody Role role){
        roleService.addRole(role);
    }

    @DeleteMapping("/role")
    public void deleteRole(@RequestBody Role role){
        roleService.deleteRole(role);
    }

    @PatchMapping("/role")
    public void editRole(@RequestBody Role role){
        roleService.editRole(role);
    }

    @PostMapping("/roleAndRoleMenu")
    public void addRoleAndRoleMenu(@RequestBody Role role) throws DuplicateNameException {
        roleService.addRoleAndRoleMenu(role);
    }

}
