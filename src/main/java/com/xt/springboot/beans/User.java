package com.xt.springboot.beans;

import javax.persistence.*;

/**
 * @author xt
 * @date 2019/3/17 - 6:31
 * @description
 */
@Entity
@Table(name="tbl_user")
public class User {

    private Integer id; //
    private String lastName; //
    private String email; //

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
