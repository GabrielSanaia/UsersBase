package com.example.UsersBase.Service;

import com.example.UsersBase.Exception.DuplicateNameException;
import com.example.UsersBase.Model.Role;
import com.example.UsersBase.Model.RoleMenu;
import com.example.UsersBase.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMenuService roleMenuService;

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleRepository.deleteById(role.getId());
    }

    @Override
    public void editRole(Role role) {
        Role entity = roleRepository.findById(role.getId()).get();

        if(role.getNameEn() != null)
            entity.setNameEn(role.getNameEn());

        if(role.getNameGeo() != null)
            entity.setNameGeo(role.getNameGeo());

        if(role.getRoleMenus() != null)
            entity.setRoleMenus(role.getRoleMenus());

        roleRepository.save(entity);
    }

    @Override
    public Role getRoleById(Long Id) {
        return roleRepository.findById(Id).get();
    }

    @Transactional
    @Override
    public void addRoleAndRoleMenu(Role role) throws DuplicateNameException {
        List<RoleMenu> menus = role.getRoleMenus();
        RoleMenu roleMenu = menus.get(0);

       if(roleMenuService.roleMenuExists(roleMenu) || roleExists(role))
           throw new DuplicateNameException();

        RoleMenu savedMenu = roleMenuService.addRoleMenu(roleMenu);

        menus.clear();
        menus.add(savedMenu);
        role.setRoleMenus(menus);

       roleRepository.save(role);
    }

    private boolean roleExists(Role role){

        Role roleEn = new Role();
        Role roleGeo = new Role();

        roleEn.setNameEn(role.getNameEn());
        roleGeo.setNameGeo(role.getNameGeo());

        Example<Role> exampleEn = Example.of(roleEn);
        Example<Role> exampleGeo = Example.of(roleGeo);

        if(roleRepository.findAll(exampleEn).isEmpty() && roleRepository.findAll(exampleGeo).isEmpty())
            return false;

        return true;
    }
}
