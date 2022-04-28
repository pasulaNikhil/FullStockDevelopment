package com.medicare.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
    
    @Id
    private int id;
    private String role;
     @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore 
    private Set<UserRole> userRoles = new HashSet<>();

    
    public Role() {
    }

    
    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }
    


    public Set<UserRole> getUserRoles() {
        return userRoles;
    }


    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    

}
