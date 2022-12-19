package com.example.UsersBase.Service;

import com.example.UsersBase.Model.RoleMenu;
import org.springframework.data.domain.Example;

import java.util.List;

public interface RoleMenuService {

    RoleMenu addRoleMenu(RoleMenu roleMenu);
    void deleteRoleMenu(RoleMenu roleMenu);
    void editRoleMenu(RoleMenu roleMenu);
    boolean roleMenuExists(RoleMenu roleMenu);


}
