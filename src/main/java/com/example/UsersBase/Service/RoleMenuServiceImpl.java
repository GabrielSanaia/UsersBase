package com.example.UsersBase.Service;


import com.example.UsersBase.Model.Role;
import com.example.UsersBase.Model.RoleMenu;
import com.example.UsersBase.Repository.RoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    RoleMenuRepository roleMenuRepository;

    @Override
    public RoleMenu addRoleMenu(RoleMenu roleMenu) {
        return roleMenuRepository.save(roleMenu);
    }

    @Override
    public void deleteRoleMenu(RoleMenu roleMenu) {
        roleMenuRepository.deleteById(roleMenu.getId());
    }

    @Override
    public void editRoleMenu(RoleMenu roleMenu) {
        RoleMenu entity = roleMenuRepository.findById(roleMenu.getId()).get();

        if(roleMenu.getNameEn() != null)
            entity.setNameEn(roleMenu.getNameEn());

        if(roleMenu.getNameGeo() != null)
            entity.setNameGeo(roleMenu.getNameGeo());

        roleMenuRepository.save(entity);
    }

    @Override
    public boolean roleMenuExists(RoleMenu roleMenu) {

        RoleMenu menuEn = new RoleMenu();
        RoleMenu menuGeo = new RoleMenu();

        menuEn.setNameEn(roleMenu.getNameEn());
        menuGeo.setNameEn(roleMenu.getNameGeo());

        Example<RoleMenu> exampleEn = Example.of(menuEn);
        Example<RoleMenu> exampleGeo = Example.of(menuEn);

        if(roleMenuRepository.findAll(exampleEn).isEmpty() && roleMenuRepository.findAll(exampleGeo).isEmpty())
            return false;

        return true;
    }


}
