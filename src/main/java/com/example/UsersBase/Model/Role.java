package com.example.UsersBase.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private Long Id;

    @Column(unique = true)
    private String nameEn;

    @Column(unique = true)
    private String nameGeo;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "role")
    private List<User> users;

    @ManyToMany
    private List<RoleMenu> roleMenus;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameGeo() {
        return nameGeo;
    }

    public void setNameGeo(String nameGeo) {
        this.nameGeo = nameGeo;
    }

    public List<RoleMenu> getRoleMenus() {
        return roleMenus;
    }

    public void setRoleMenus(List<RoleMenu> roleMenues) {
        this.roleMenus = roleMenues;
    }
}
