package com.example.UsersBase.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoleMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(unique = true)
    private String nameEn;

    @Column(unique = true)
    private String nameGeo;



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

}
