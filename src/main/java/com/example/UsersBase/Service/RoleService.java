package com.example.UsersBase.Service;

import com.example.UsersBase.Exception.DuplicateNameException;
import com.example.UsersBase.Model.*;

public interface RoleService {

    void addRole(Role role);

    void deleteRole(Role role);

    void editRole(Role role);

    Role getRoleById(Long Id);

    void addRoleAndRoleMenu(Role role) throws DuplicateNameException;



}
