package com.example.UsersBase.Controller;

import com.example.UsersBase.Model.RoleMenu;
import com.example.UsersBase.Repository.RoleMenuRepository;
import com.example.UsersBase.Service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleMenuController {

    @Autowired
    RoleMenuService roleMenuService;

    @PostMapping("/roleMenu")
    public void addRoleMenu(@RequestBody RoleMenu roleMenu){
        roleMenuService.addRoleMenu(roleMenu);
    }

    @DeleteMapping("/roleMenu")
    public void deleteRoleMenu(@RequestBody RoleMenu roleMenu){
        roleMenuService.deleteRoleMenu(roleMenu);
    }

    @PatchMapping("/roleMenu")
    public void editRoleMenu(@RequestBody RoleMenu roleMenu){
        roleMenuService.editRoleMenu(roleMenu);
    }

}
